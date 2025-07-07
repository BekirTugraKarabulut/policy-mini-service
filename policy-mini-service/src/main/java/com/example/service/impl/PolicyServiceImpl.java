package com.example.service.impl;

import com.example.dto.DtoPolicy;
import com.example.dto.DtoPolicyUI;
import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.model.Policy;
import com.example.repository.PolicyRepository;
import com.example.service.PolicyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

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

}
