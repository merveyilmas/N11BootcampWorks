package com.merveyilmaz.productservice.controller;

import com.merveyilmaz.productservice.controller.contract.CategoryControllerContract;
import com.merveyilmaz.productservice.dto.CategoryDTO;
import com.merveyilmaz.productservice.request.CategorySaveRequest;
import com.merveyilmaz.productservice.general.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryControllerContract categoryControllerContract;

    public CategoryController(CategoryControllerContract categoryControllerContract) {
        this.categoryControllerContract = categoryControllerContract;
    }

    @PostMapping
    public ResponseEntity<RestResponse<CategoryDTO>> saveCategory(@RequestBody CategorySaveRequest request) {
        CategoryDTO categoryDto = categoryControllerContract.saveCategory(request);
        return ResponseEntity.ok(RestResponse.of(categoryDto));
    }

}
