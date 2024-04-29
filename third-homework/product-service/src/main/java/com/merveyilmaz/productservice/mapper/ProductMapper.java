package com.merveyilmaz.productservice.mapper;

import com.merveyilmaz.productservice.dto.ProductDTO;
import com.merveyilmaz.productservice.entitiy.Product;
import com.merveyilmaz.productservice.request.ProductSaveRequest;
import com.merveyilmaz.productservice.response.ProductWithCategoryNameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product convertToProduct(ProductSaveRequest request);
    ProductDTO convertToProductDTO(Product product);
    @Mapping(target = "categoryName", source = "categoryName")
    ProductWithCategoryNameDTO convertToProductWithCategoryNameDTO(Product product, String categoryName);
}
