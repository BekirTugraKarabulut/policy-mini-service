package com.example.service;

import com.example.dto.*;

import java.util.List;

public interface PolicyService {

    public DtoCollection  getCollectionStatusByPolicyId(Long policyId);

    public DtoUrun getProductByProductId(Integer urunId);

    public DtoMusteri getMusteriByTckn(String tckn);

    public List<DtoPolicy> allPolicies();

    public DtoPolicy findById(Long policyId);

    public DtoPolicy savePolicy(DtoPolicyUI dtoPolicyUI);

    public DtoPolicy updatePolicy(Long policyId,DtoPolicyUI dtoPolicyUI);

    public void deletePolicy(Long policyId);

    public DtoPolicy durumPolicyById(Long policyId);

    public List<DtoCollection> odenmeDurumuFalseByPolicyId(Long policyId);

    public DtoCollection durumCollection(Integer collectionId , DtoCollectionUI dtoCollectionUI);

    public List<DtoCollection> odenmemisVeSuresiDolmusCollectionListesi();

}
