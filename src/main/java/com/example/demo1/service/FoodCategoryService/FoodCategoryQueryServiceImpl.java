package com.example.demo1.service.FoodCategoryService;

import com.example.demo1.repository.foodcatrgoryRepository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existsAllByIds(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
