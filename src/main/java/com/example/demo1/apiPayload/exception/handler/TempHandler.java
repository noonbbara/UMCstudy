package com.example.demo1.apiPayload.exception.handler;

import com.example.demo1.apiPayload.code.BaseErrorCode;
import com.example.demo1.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}