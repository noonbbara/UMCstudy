package com.example.demo1.repository.StoreRepository;

import com.example.demo1.domain.Store;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}