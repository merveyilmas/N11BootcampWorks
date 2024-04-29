package com.merveyilmaz.secondhomework.controller.contract;

import com.merveyilmaz.secondhomework.dto.CategoryDTO;
import com.merveyilmaz.secondhomework.request.CategorySaveRequest;

import java.util.List;

public interface CategoryControllerContract {

    List<CategoryDTO> getAllCategoriess();

    CategoryDTO getCategoryById(Long id);

    CategoryDTO saveCategory(CategorySaveRequest request);

    void deleteCategory(Long id);
}
