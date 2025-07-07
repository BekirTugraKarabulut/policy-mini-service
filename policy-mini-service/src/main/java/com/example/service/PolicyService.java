package com.example.service;

import com.example.dto.DtoPolicy;
import com.example.dto.DtoPolicyUI;

import java.util.List;

public interface PolicyService {

    public List<DtoPolicy> allPolicies();

    public DtoPolicy findById(Long policyId);

    public DtoPolicy savePolicy(DtoPolicyUI dtoPolicyUI);

    public DtoPolicy updatePolicy(Long policyId,DtoPolicyUI dtoPolicyUI);

    public void deletePolicy(Long policyId);

}
