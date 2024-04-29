package com.merveyilmaz.productservice.dao;

import com.merveyilmaz.productservice.entitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
