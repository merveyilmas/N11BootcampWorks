package com.merveyilmaz.secondhomework.dao;

import com.merveyilmaz.secondhomework.entitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
