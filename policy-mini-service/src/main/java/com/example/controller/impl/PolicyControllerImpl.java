package com.example.controller.impl;

import com.example.controller.PolicyController;
import com.example.dto.*;
import com.example.service.PolicyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api")
@Tag(name = "Policy Controller" , description = "Policy API'leri")
public class PolicyControllerImpl implements PolicyController {

    @Autowired
    private PolicyService policyService;

    @Override
    @GetMapping(path = "/collection/{policyId}")
    public DtoCollection getCollectionStatusByPolicyId(@PathVariable(name = "policyId" , required = true) Long policyId) {
        return policyService.getCollectionStatusByPolicyId(policyId);
    }

    @Override
    @GetMapping(path = "/urun/{urunId}")
    public DtoUrun getProductByProductId(@PathVariable(name = "urunId",required = true) Integer urunId) {
        return policyService.getProductByProductId(urunId);
    }

    @Override
    @GetMapping(path = "/musteri/{tckn}")
    public DtoMusteri getMusteriByTckn(@PathVariable(name = "tckn" , required = true) String tckn) {
        return policyService.getMusteriByTckn(tckn);
    }

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

    @Override
    @GetMapping(path = "/durumlar")
    public DtoPolicy durumPolicyById(Long policyId) {
        return policyService.durumPolicyById(policyId);
    }

    @Override
    @GetMapping(path = "collection-odenmemis/{policyId}")
    public List<DtoCollection> odenmeDurumuFalseByPolicyId(@PathVariable(name = "policyId" , required = true) Long policyId) {
        return policyService.odenmeDurumuFalseByPolicyId(policyId);
    }

    @Override
    @PutMapping(path = "/collection-guncelle/{collectionId}")
    public DtoCollection durumCollection(@PathVariable(name = "collectionId" , required = true) Integer collectionId,@RequestBody DtoCollectionUI dtoCollectionUI) {
        return policyService.durumCollection(collectionId,dtoCollectionUI);
    }

    @Override
    @GetMapping(path = "/collection-suresi-gecmis-ve-odenmemis")
    public List<DtoCollection> odenmemisVeSuresiDolmusCollectionListesi() {
        return policyService.odenmemisVeSuresiDolmusCollectionListesi();
    }

}