package com.merveyilmaz.productservice.service.entityService;

import com.merveyilmaz.productservice.dao.CategoryRepository;
import com.merveyilmaz.productservice.entitiy.Category;
import com.merveyilmaz.productservice.general.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CategoryEntityService extends BaseEntityService<Category, CategoryRepository> {

    protected CategoryEntityService(CategoryRepository repository) {
        super(repository);
    }


}
