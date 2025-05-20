package com.example.demo1.repository.ReviewRepository;

import com.example.demo1.domain.Review;
import com.example.demo1.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}

