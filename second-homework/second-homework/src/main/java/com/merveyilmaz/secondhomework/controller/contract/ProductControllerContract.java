package com.merveyilmaz.secondhomework.controller.contract;

import com.merveyilmaz.secondhomework.dto.ProductDTO;
import com.merveyilmaz.secondhomework.request.ProductSaveRequest;
import com.merveyilmaz.secondhomework.request.ProductUpdatePriceRequest;

import java.util.List;

public interface ProductControllerContract {

    List<ProductDTO> getAllActiveProducts();

    List<ProductDTO> getAllActiveProductsByExpirationDateLE();

    ProductDTO getActiveProductById(Long id);

    ProductDTO getActiveProductByCategoryId(Long categoryId);

    ProductDTO saveProduct(ProductSaveRequest request);

    ProductDTO updateProductByPrice(Long debugProductId, ProductUpdatePriceRequest request);

    List<ProductDTO> updateProductsByPrice(List<ProductUpdatePriceRequest> requests);

    ProductDTO updateProductByActivate(Long id);

    ProductDTO updateProductByDeactivate(Long id);
}
