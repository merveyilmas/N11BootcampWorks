package com.merveyilmaz.secondhomework.controller.contract.impl;

import com.merveyilmaz.secondhomework.controller.contract.ProductControllerContract;
import com.merveyilmaz.secondhomework.dto.ProductDTO;
import com.merveyilmaz.secondhomework.entitiy.Product;
import com.merveyilmaz.secondhomework.enums.EnumStatus;
import com.merveyilmaz.secondhomework.mapper.ProductMapper;
import com.merveyilmaz.secondhomework.request.ProductSaveRequest;
import com.merveyilmaz.secondhomework.request.ProductUpdatePriceRequest;
import com.merveyilmaz.secondhomework.service.entityService.ProductEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;

    @Override
    public List<ProductDTO> getAllActiveProducts() {

        List<Product> productList = productEntityService.findAllActiveProducts();

        return ProductMapper.INSTANCE.convertToProductDtos(productList);
    }

    @Override
    public List<ProductDTO> getAllActiveProductsByExpirationDateLE() {

        List<Product> productList = productEntityService.findAllActiveProductsByExpirationDateLE();

        return ProductMapper.INSTANCE.convertToProductDtos(productList);
    }

    @Override
    public ProductDTO getActiveProductById(Long id) {
        Product product = productEntityService.findActiveProductById(id);
        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    @Override
    public ProductDTO getActiveProductByCategoryId(Long categoryId) {
        Product product = productEntityService.findActiveProductByCategoryId(categoryId);
        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    @Override
    public ProductDTO saveProduct(ProductSaveRequest request) {
        Product product = ProductMapper.INSTANCE.convertToProduct(request);

        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    @Override
    public ProductDTO updateProductByPrice(Long debugProductId, ProductUpdatePriceRequest request) {
        Product product = productEntityService.findByIdWithControl(debugProductId);

        product.setPrice(request.newPrice());
        productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ProductDTO> updateProductsByPrice(List<ProductUpdatePriceRequest> requests) {
        List<ProductDTO> updatedProductDtos = new ArrayList<>();

        for (ProductUpdatePriceRequest request : requests) {
            Long productId = request.id();
            double newPrice = request.newPrice();

            Product product = productEntityService.findByIdWithControl(productId);
            product.setPrice(newPrice);
            productEntityService.save(product);

            updatedProductDtos.add(ProductMapper.INSTANCE.convertToProductDto(product));
        }

        return updatedProductDtos;
    }

    @Override
    public ProductDTO updateProductByActivate(Long id) {
        Product product = productEntityService.findByIdWithControl(id);

        product.setStatus(EnumStatus.ACTIVE);
        productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    @Override
    public ProductDTO updateProductByDeactivate(Long id) {
        Product product = productEntityService.findByIdWithControl(id);

        product.setStatus(EnumStatus.PASSIVE);
        productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDto(product);
    }
}
