package com.ankit.JobApplication.reviews.services;

import com.ankit.JobApplication.company.entity.Company;
import com.ankit.JobApplication.reviews.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {


    Review getReviewById(Long reviewId,Long companyId);

    boolean saveReview(Long companyId ,Review review);

    boolean deleteReviewById(Long id,Long companyId);

    boolean updateReviewById(Long id, Long companyId, Review review);

    List<Review> getAllReview(Long companyId);
}
