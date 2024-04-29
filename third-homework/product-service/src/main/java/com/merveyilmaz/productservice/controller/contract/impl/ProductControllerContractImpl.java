package com.merveyilmaz.productservice.controller.contract.impl;

import com.merveyilmaz.productservice.controller.contract.ProductControllerContract;
import com.merveyilmaz.productservice.dto.ProductDTO;
import com.merveyilmaz.productservice.entitiy.Category;
import com.merveyilmaz.productservice.entitiy.Product;
import com.merveyilmaz.productservice.mapper.ProductMapper;
import com.merveyilmaz.productservice.request.ProductSaveRequest;
import com.merveyilmaz.productservice.response.ProductWithCategoryNameDTO;
import com.merveyilmaz.productservice.service.entityService.CategoryEntityService;
import com.merveyilmaz.productservice.service.entityService.ProductEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;
    private final CategoryEntityService categoryEntityService;

    @Override
    public ProductWithCategoryNameDTO getProductById(Long id) {
        Product product = productEntityService.findByIdWithControl(id);
        Category category = categoryEntityService.findByIdWithControl(product.getCategoryId());

        return ProductMapper.INSTANCE.convertToProductWithCategoryNameDTO(product, category.getName());
    }

    @Override
    public ProductDTO saveProduct(ProductSaveRequest request) {
        Product product = ProductMapper.INSTANCE.convertToProduct(request);

        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }

}
