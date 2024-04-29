package com.merveyilmaz.secondhomework.controller.contract.impl;

import com.merveyilmaz.secondhomework.controller.contract.CategoryControllerContract;
import com.merveyilmaz.secondhomework.dto.CategoryDTO;
import com.merveyilmaz.secondhomework.entitiy.Category;
import com.merveyilmaz.secondhomework.mapper.CategoryMapper;
import com.merveyilmaz.secondhomework.request.CategorySaveRequest;
import com.merveyilmaz.secondhomework.service.entityService.CategoryEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CategoryControllerContractImpl implements CategoryControllerContract {

    private final CategoryEntityService categoryEntityService;

    @Override
    public List<CategoryDTO> getAllCategoriess() {
        List<Category> categoryList = categoryEntityService.findAll();

        return CategoryMapper.INSTANCE.convertToCategoryDtos(categoryList);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryEntityService.findByIdWithControl(id);
        return CategoryMapper.INSTANCE.convertToCategoryDto(category);
    }

    @Override
    public CategoryDTO saveCategory(CategorySaveRequest request) {

        Category category = CategoryMapper.INSTANCE.convertToCategory(request);

        category = categoryEntityService.save(category);

        return CategoryMapper.INSTANCE.convertToCategoryDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryEntityService.delete(id);
    }
}
