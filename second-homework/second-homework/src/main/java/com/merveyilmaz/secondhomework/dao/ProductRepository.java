package com.merveyilmaz.secondhomework.dao;

import com.merveyilmaz.secondhomework.entitiy.Category;
import com.merveyilmaz.secondhomework.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByCategoryId(Category category);
}
