package com.example.service.impl;

import com.example.dto.*;
import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.feign.CollectionServiceFeign;
import com.example.feign.MusterServiceFeign;
import com.example.feign.UrunServiceFeign;
import com.example.model.Policy;
import com.example.repository.PolicyRepository;
import com.example.service.PolicyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private MusterServiceFeign musterServiceFeign;

    @Autowired
    private UrunServiceFeign urunServiceFeign;

    @Autowired
    private CollectionServiceFeign  collectionServiceFeign;

    @Override
    public DtoCollection getCollectionStatusByPolicyId(Long policyId) {

        DtoCollection dtoCollection = collectionServiceFeign.getCollectionStatusByPolicyId(policyId);

        if (dtoCollection == null) {
            return null;
        }

        return dtoCollection;
    }

    @Override
    public DtoUrun getProductByProductId(Integer urunId) {

        DtoUrun dtoUrun = urunServiceFeign.getProductByProductId(urunId);

        if (dtoUrun == null) {
            return  null;
        }

        return dtoUrun;
    }

    @Override
    public DtoMusteri getMusteriByTckn(String tckn) {

        DtoMusteri dtoMusteri = musterServiceFeign.getMusteriByTckn(tckn);

        if (dtoMusteri == null) {
            return null;
        }

        return dtoMusteri;
    }

    @Override
    public List<DtoPolicy> allPolicies() {

        List<Policy> policies = policyRepository.findAll();
        List<DtoPolicy> dtoPolicies = new ArrayList<>();

        for (Policy policy : policies) {
            DtoPolicy dtoPolicy = new DtoPolicy();
            BeanUtils.copyProperties(policy, dtoPolicy);
            dtoPolicies.add(dtoPolicy);
        }

        return dtoPolicies;
    }

    @Override
    public DtoPolicy findById(Long policyId) {

        Policy policy = policyRepository.findByPolicyId(policyId);

        if(policy == null){
            throw new BaseException(new ErrorMessage(MessageType.POLICY_BULUNAMADI , policy.getPolicyId().toString()));
        }

        DtoPolicy dtoPolicy = new DtoPolicy();
        BeanUtils.copyProperties(policy, dtoPolicy);

        return dtoPolicy;
    }

    @Override
    public DtoPolicy savePolicy(DtoPolicyUI dtoPolicyUI) {

        Policy policy = new Policy();

        policy.setMusteriId(dtoPolicyUI.getMusteriId());
        policy.setUrunId(dtoPolicyUI.getUrunId());
        policy.setPolicyDate(dtoPolicyUI.getPolicyDate());

        if(new Date().before(policy.getPolicyDate())){
            policy.setStatus("AKTİF");
        }

        if(new Date().after(policy.getPolicyDate())){
            policy.setStatus("PASİF");
        }

        Policy dbPolicy = policyRepository.save(policy);
        DtoPolicy dtoPolicy = new DtoPolicy();
        BeanUtils.copyProperties(dbPolicy,dtoPolicy);

        return dtoPolicy;
    }

    @Override
    public DtoPolicy updatePolicy(Long policyId, DtoPolicyUI dtoPolicyUI) {

        Policy policy = policyRepository.findByPolicyId(policyId);

        if(policy == null){
            throw new BaseException(new ErrorMessage(MessageType.POLICY_BULUNAMADI , policy.getPolicyId().toString()));
        }

        policy.setMusteriId(dtoPolicyUI.getMusteriId());
        policy.setUrunId(dtoPolicyUI.getUrunId());
        policy.setPolicyDate(dtoPolicyUI.getPolicyDate());

        Policy updatePolicy = policyRepository.save(policy);
        DtoPolicy dtoPolicy = new DtoPolicy();
        BeanUtils.copyProperties(updatePolicy,dtoPolicy);

        return dtoPolicy;
    }

    @Override
    public void deletePolicy(Long policyId) {

        Optional<Policy> policy = policyRepository.findById(policyId);

        if(policy.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.POLICY_BULUNAMADI , policy.toString()));
        }

        policyRepository.delete(policy.get());
    }

    @Override
    public DtoPolicy durumPolicyById(Long policyId) {

        Policy policy = policyRepository.findByPolicyId(policyId);

        if (policy == null) {
            return null;
        }

        if(new Date().before(policy.getPolicyDate())){
            policy.setStatus("AKTİF");
        }else{
            policy.setStatus("PASİF");
        }
        return null;
    }

    @Override
    public List<DtoCollection> odenmeDurumuFalseByPolicyId(Long policyId) {

        List<DtoCollection> dtoCollections = collectionServiceFeign.odenmeDurumuFalseByPolicyId(policyId);

        if (dtoCollections.isEmpty()) {
            return null;
        }

        return dtoCollections;
    }

    @Override
    public DtoCollection durumCollection(Integer collectionId, DtoCollectionUI dtoCollectionUI) {

        DtoCollection dtoCollection = collectionServiceFeign.findByCollectionId(collectionId);

        if(dtoCollection == null){
            return null;
        }

        return collectionServiceFeign.guncelle(dtoCollection.getCollectionId(), dtoCollectionUI);
    }

    @Override
    public List<DtoCollection> odenmemisVeSuresiDolmusCollectionListesi() {

        List<DtoCollection> dtoCollections = collectionServiceFeign.suresiDolmusVeOdenmemislerinTumu();

        if (dtoCollections.isEmpty()) {
            return null;
        }

        return dtoCollections;
    }


}
