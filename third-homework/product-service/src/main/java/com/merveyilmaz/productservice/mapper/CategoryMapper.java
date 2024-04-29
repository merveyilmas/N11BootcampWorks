package com.merveyilmaz.productservice.mapper;

import com.merveyilmaz.productservice.dto.CategoryDTO;
import com.merveyilmaz.productservice.entitiy.Category;
import com.merveyilmaz.productservice.request.CategorySaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category convertToCategory(CategorySaveRequest request);
    CategoryDTO convertToCategoryDTO(Category category);
}
