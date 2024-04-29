package com.merveyilmaz.productservice.dao;

import com.merveyilmaz.productservice.entitiy.Category;
import com.merveyilmaz.productservice.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
