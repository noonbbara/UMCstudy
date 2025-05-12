package com.example.demo1.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryQueryService {
    boolean existsAllByIds(List<Long> ids);
}
