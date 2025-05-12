package com.example.demo1.apiPayload.exception.handler;

import com.example.demo1.apiPayload.code.BaseErrorCode;
import com.example.demo1.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}


