package com.merveyilmaz.secondhomework.mapper;

import com.merveyilmaz.secondhomework.dto.CategoryDTO;
import com.merveyilmaz.secondhomework.entitiy.Category;
import com.merveyilmaz.secondhomework.request.CategorySaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category convertToCategory(CategorySaveRequest request);
    CategoryDTO convertToCategoryDto(Category category);
    List<CategoryDTO> convertToCategoryDtos(List<Category> categories);
}
