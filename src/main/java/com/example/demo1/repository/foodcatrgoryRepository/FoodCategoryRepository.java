package com.example.demo1.repository.foodcatrgoryRepository;

import com.example.demo1.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}