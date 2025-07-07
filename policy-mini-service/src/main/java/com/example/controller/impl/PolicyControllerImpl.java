package com.example.controller.impl;

import com.example.controller.PolicyController;
import com.example.dto.DtoPolicy;
import com.example.dto.DtoPolicyUI;
import com.example.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api")
public class PolicyControllerImpl implements PolicyController {

    @Autowired
    private PolicyService policyService;

    @Override
    @GetMapping(path = "/all-policy")
    public List<DtoPolicy> allPolicies() {
        return policyService.allPolicies();
    }

    @Override
    @GetMapping(path = "/policy/{policyId}")
    public DtoPolicy findById(@PathVariable(name = "policyId" , required = true) Long policyId) {
        return policyService.findById(policyId);
    }

    @Override
    @PostMapping(path = "/policy-ekle")
    public DtoPolicy savePolicy(@RequestBody DtoPolicyUI dtoPolicyUI) {
        return policyService.savePolicy(dtoPolicyUI);
    }

    @Override
    @PutMapping(path = "/guncelle/{policyId}")
    public DtoPolicy updatePolicy(@PathVariable(name = "policyId" , required = true) Long policyId,@RequestBody DtoPolicyUI dtoPolicyUI) {
        return policyService.updatePolicy(policyId,dtoPolicyUI);
    }

    @Override
    @DeleteMapping(path = "/delete/{policyId}")
    public void deletePolicy(@PathVariable(name = "policyId" , required = true) Long policyId) {
        policyService.deletePolicy(policyId);
    }

}
