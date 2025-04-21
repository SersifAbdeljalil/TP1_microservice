package com.microservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER")
public interface CustomerClient {

    @GetMapping("/api/v1/customers/{id}")
    CustomerDto findById(@PathVariable("id") Integer id); // ✅ Corrigé
}


