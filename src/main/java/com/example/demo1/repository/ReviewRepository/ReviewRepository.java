package com.example.demo1.repository.ReviewRepository;

import com.example.demo1.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

}
