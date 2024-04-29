package com.merveyilmaz.secondhomework.controller;

import com.merveyilmaz.secondhomework.controller.contract.ProductControllerContract;
import com.merveyilmaz.secondhomework.dto.ProductDTO;
import com.merveyilmaz.secondhomework.request.ProductSaveRequest;
import com.merveyilmaz.secondhomework.request.ProductUpdatePriceRequest;
import com.merveyilmaz.secondhomework.response.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductControllerContract productControllerContract;

    public ProductController(ProductControllerContract productControllerContract) {
        this.productControllerContract = productControllerContract;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> getAllActiveProducts() {
        List<ProductDTO> allProducts = productControllerContract.getAllActiveProducts();
        return ResponseEntity.ok(RestResponse.of(allProducts));
    }

    @GetMapping("/with-expirationDateLE")
    public ResponseEntity<RestResponse<List<ProductDTO>>> getAllActiveProductsByExpirationDateLE() {
        List<ProductDTO> allProducts = productControllerContract.getAllActiveProductsByExpirationDateLE();
        return ResponseEntity.ok(RestResponse.of(allProducts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> getActiveProductById(@PathVariable Long id) {
        ProductDTO productById = productControllerContract.getActiveProductById(id);
        return ResponseEntity.ok(RestResponse.of(productById));
    }

    @GetMapping("/with-categoryId/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> getActiveProductByCategoryId(@PathVariable Long id) {
        ProductDTO productById = productControllerContract.getActiveProductByCategoryId(id);
        return ResponseEntity.ok(RestResponse.of(productById));
    }

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> saveProduct(@RequestBody ProductSaveRequest request) {
        ProductDTO productDto = productControllerContract.saveProduct(request);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @PatchMapping("/{debugProductId}/price")
    public ResponseEntity<RestResponse<ProductDTO>> updateProductByPrice(@PathVariable Long debugProductId, @RequestBody
    ProductUpdatePriceRequest request) {
        ProductDTO productDto = productControllerContract.updateProductByPrice(debugProductId, request);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @PatchMapping("/batch-update-price")
    public ResponseEntity<RestResponse<List<ProductDTO>>> updateProductsByPrice(@RequestBody List<ProductUpdatePriceRequest> requests) {
        List<ProductDTO> productDtos = productControllerContract.updateProductsByPrice(requests);
        return ResponseEntity.ok(RestResponse.of(productDtos));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<RestResponse<ProductDTO>> updateProductByActivate(@PathVariable Long id) {
        ProductDTO productDto = productControllerContract.updateProductByActivate(id);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<RestResponse<ProductDTO>> updateProductByDeactivate(@PathVariable Long id) {
        ProductDTO productDto = productControllerContract.updateProductByDeactivate(id);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }
}
