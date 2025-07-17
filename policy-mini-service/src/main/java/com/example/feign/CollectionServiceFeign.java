package com.example.feign;

import com.example.dto.DtoCollection;
import com.example.dto.DtoCollectionUI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@FeignClient(value = "collection-service-feign" , url = "http://localhost:8082")
public interface CollectionServiceFeign {

    @GetMapping(path = "/rest/api/policy/{policyId}")
    DtoCollection getCollectionStatusByPolicyId(@PathVariable(name = "policyId") Long policyId);

    @GetMapping(path = "/rest/api/odenmemis/{policyId}")
    List<DtoCollection> odenmeDurumuFalseByPolicyId(@PathVariable(name = "policyId" , required = true) Long policyId);

    @GetMapping(path = "/rest/api/collection/{collectionId}")
    DtoCollection findByCollectionId(@PathVariable(name = "collectionId" , required = true) Integer collectionId);

    @PutMapping(path = "/rest/api/collection-guncelle/{collectionId}")
    DtoCollection guncelle(@PathVariable(name = "collectionId" , required = true) Integer collectionId,@RequestBody DtoCollectionUI dtoCollectionUI);

}
