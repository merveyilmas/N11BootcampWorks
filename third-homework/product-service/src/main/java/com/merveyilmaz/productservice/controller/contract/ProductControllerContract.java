package com.merveyilmaz.productservice.controller.contract;

import com.merveyilmaz.productservice.dto.ProductDTO;
import com.merveyilmaz.productservice.request.ProductSaveRequest;
import com.merveyilmaz.productservice.response.ProductWithCategoryNameDTO;

public interface ProductControllerContract {

    ProductWithCategoryNameDTO getProductById(Long id);
    ProductDTO saveProduct(ProductSaveRequest request);

}
