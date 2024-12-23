package com.ankit.JobApplication.reviews.services.serviceImpl;

import com.ankit.JobApplication.company.entity.Company;
import com.ankit.JobApplication.company.services.CompanyService;
import com.ankit.JobApplication.reviews.entity.Review;
import com.ankit.JobApplication.reviews.repository.ReviewRepository;
import com.ankit.JobApplication.reviews.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }
//find the reviews by companyId then convert into streams if review if is = to para reviewId then take out the first
    @Override
    public Review getReviewById(Long companyId,Long reviewId) {
       List<Review> reviews = reviewRepository.findByCompanyId(companyId);
       return reviews
               .stream()
               .filter(review -> review.getId().equals(reviewId))
               .findFirst()
               .orElse(null);

    }

    @Override
    public boolean saveReview(Long companyId,Review review) {
        Company company = companyService.getById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteReviewById(Long id,Long companyId) {
        if(companyService.getById(companyId)!=null &&
        reviewRepository.existsById(id)){
            Review review = reviewRepository.findById(id).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompById(companyId,company);
            reviewRepository.deleteById(id);
            return true;

        }else{
            return false;
        }

    }

    @Override
    public boolean updateReviewById(Long id, Long companyId, Review updatedreview) {
        if(companyService.getById(companyId)!=null){
            updatedreview.setCompany(companyService.getById(companyId));
            updatedreview.setId(id);
            reviewRepository.save(updatedreview);
            return true;
        }
        return false;

    }

    @Override
    public List<Review> getAllReview(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }


}
