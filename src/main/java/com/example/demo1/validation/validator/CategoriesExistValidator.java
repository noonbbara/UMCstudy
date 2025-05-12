package com.example.demo1.validation.validator;

import com.example.demo1.apiPayload.code.status.ErrorStatus;
import com.example.demo1.repository.foodcatrgoryRepository.FoodCategoryRepository;
import com.example.demo1.service.FoodCategoryService.FoodCategoryQueryService;
import com.example.demo1.validation.annotation.ExistCategories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {


    private final FoodCategoryQueryService foodCategoryService;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        if (values == null || values.isEmpty()) {
            return true; // 또는 false로 바꿀 수도 있음
        }

        boolean isValid = foodCategoryService.existsAllByIds(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString() // 필요시 getMessage() 등으로 수정
            ).addConstraintViolation();
        }

        return isValid;
    }
}
