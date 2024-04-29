package com.merveyilmaz.productservice.controller;

import com.merveyilmaz.productservice.controller.contract.ProductControllerContract;
import com.merveyilmaz.productservice.dto.ProductDTO;
import com.merveyilmaz.productservice.request.ProductSaveRequest;
import com.merveyilmaz.productservice.general.RestResponse;
import com.merveyilmaz.productservice.response.ProductWithCategoryNameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductControllerContract productControllerContract;

    public ProductController(ProductControllerContract productControllerContract) {
        this.productControllerContract = productControllerContract;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductWithCategoryNameDTO>> getProductById(@PathVariable Long id) {
        ProductWithCategoryNameDTO productWithCategoryName = productControllerContract.getProductById(id);
        return ResponseEntity.ok(RestResponse.of(productWithCategoryName));
    }

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> saveProduct(@RequestBody ProductSaveRequest request) {
        ProductDTO productDto = productControllerContract.saveProduct(request);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

}
