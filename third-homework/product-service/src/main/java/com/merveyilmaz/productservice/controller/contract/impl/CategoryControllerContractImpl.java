package com.merveyilmaz.productservice.controller.contract.impl;

import com.merveyilmaz.productservice.controller.contract.CategoryControllerContract;
import com.merveyilmaz.productservice.dto.CategoryDTO;
import com.merveyilmaz.productservice.entitiy.Category;
import com.merveyilmaz.productservice.mapper.CategoryMapper;
import com.merveyilmaz.productservice.request.CategorySaveRequest;
import com.merveyilmaz.productservice.service.entityService.CategoryEntityService;
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
    public CategoryDTO saveCategory(CategorySaveRequest request) {

        Category category = CategoryMapper.INSTANCE.convertToCategory(request);

        category = categoryEntityService.save(category);

        return CategoryMapper.INSTANCE.convertToCategoryDTO(category);
    }

}
