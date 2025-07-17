package com.example.feign;

import com.example.dto.DtoMusteri;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "musteri-service-feign" , url = "http://localhost:8085")
public interface MusterServiceFeign {

    @GetMapping(path = "/rest/api/musteri/{tckn}")
    DtoMusteri getMusteriByTckn(@PathVariable(value = "tckn" , required = true) String tckn);

    @GetMapping(path = "/rest/api/musteri/id/{musteriId}")
    DtoMusteri  getMusteriByMusteriId(@PathVariable(value = "musteriId" , required = true) int musteriId);

}
