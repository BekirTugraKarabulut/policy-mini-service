package com.example.feign;

import com.example.dto.DtoUrun;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "urun-service-feign" , url = "http://localhost:8090")
public interface UrunServiceFeign {

    @GetMapping(path = "/rest/api/urun/{urunId}")
    DtoUrun getProductByProductId(@PathVariable(value = "urunId",required = true) Integer urunId);

}
