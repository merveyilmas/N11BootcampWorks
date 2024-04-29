package com.merveyilmaz.secondhomework.service.entityService;

import com.merveyilmaz.secondhomework.dao.CategoryRepository;
import com.merveyilmaz.secondhomework.entitiy.Category;
import com.merveyilmaz.secondhomework.general.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CategoryEntityService extends BaseEntityService<Category, CategoryRepository> {

    protected CategoryEntityService(CategoryRepository repository) {
        super(repository);
    }


}
