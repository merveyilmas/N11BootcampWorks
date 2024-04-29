package com.merveyilmaz.productservice.controller.contract;

import com.merveyilmaz.productservice.dto.CategoryDTO;
import com.merveyilmaz.productservice.request.CategorySaveRequest;

import java.util.List;

public interface CategoryControllerContract {

    CategoryDTO saveCategory(CategorySaveRequest request);

}
