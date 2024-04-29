package com.merveyilmaz.productservice.service.entityService;

import com.merveyilmaz.productservice.dao.CategoryRepository;
import com.merveyilmaz.productservice.dao.ProductRepository;
import com.merveyilmaz.productservice.entitiy.Product;
import com.merveyilmaz.productservice.general.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {

    public final CategoryRepository categoryRepository;

    protected ProductEntityService(ProductRepository repository, CategoryRepository categoryRepository) {
        super(repository);
        this.categoryRepository = categoryRepository;
    }


}
