package com.merveyilmaz.secondhomework.controller;

import com.merveyilmaz.secondhomework.controller.contract.CategoryControllerContract;
import com.merveyilmaz.secondhomework.dto.CategoryDTO;
import com.merveyilmaz.secondhomework.request.CategorySaveRequest;
import com.merveyilmaz.secondhomework.response.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryControllerContract categoryControllerContract;

    public CategoryController(CategoryControllerContract categoryControllerContract) {
        this.categoryControllerContract = categoryControllerContract;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CategoryDTO>>> getAllCategoriess() {
        List<CategoryDTO> allCategories = categoryControllerContract.getAllCategoriess();
        return ResponseEntity.ok(RestResponse.of(allCategories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CategoryDTO>> getCategoryById(@PathVariable Long id) {
        CategoryDTO categoryById = categoryControllerContract.getCategoryById(id);
        return ResponseEntity.ok(RestResponse.of(categoryById));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CategoryDTO>> saveCategory(@RequestBody CategorySaveRequest request) {
        CategoryDTO categoryDto = categoryControllerContract.saveCategory(request);
        return ResponseEntity.ok(RestResponse.of(categoryDto));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryControllerContract.deleteCategory(id);
    }

}
