package com.example.demo1.repository.StoreRepository;

import com.example.demo1.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}