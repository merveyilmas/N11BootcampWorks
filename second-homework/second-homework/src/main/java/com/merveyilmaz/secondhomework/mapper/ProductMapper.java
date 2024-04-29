package com.merveyilmaz.secondhomework.mapper;

import com.merveyilmaz.secondhomework.dto.ProductDTO;
import com.merveyilmaz.secondhomework.entitiy.Product;
import com.merveyilmaz.secondhomework.request.ProductSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product convertToProduct(ProductSaveRequest request);
    ProductDTO convertToProductDto(Product product);
    List<ProductDTO> convertToProductDtos(List<Product> products);
}
