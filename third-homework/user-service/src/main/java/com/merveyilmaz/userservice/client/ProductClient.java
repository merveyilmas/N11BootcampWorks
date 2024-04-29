package com.merveyilmaz.userservice.client;

import com.merveyilmaz.userservice.dto.ProductDTO;
import com.merveyilmaz.userservice.general.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product", url = "http://localhost:8081/api/v1/products")
public interface ProductClient {

    @GetMapping("/{id}")
    RestResponse<ProductDTO> getProductById(@PathVariable Long id);
}
