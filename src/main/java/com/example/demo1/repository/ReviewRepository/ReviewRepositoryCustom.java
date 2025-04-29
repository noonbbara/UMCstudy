package com.example.demo1.repository.ReviewRepository;

import com.example.demo1.domain.Review;
import com.example.demo1.domain.Store;

import java.util.List;

public interface ReviewRepositoryCustom {
    Review saveReview(Long memberId, Long storeId, String body, Float score);
}
