package com.example.demo1.validation.validator;

import com.example.demo1.validation.annotation.ValidPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) return true; // null 허용 시
        return value >= 1;
    }
}
