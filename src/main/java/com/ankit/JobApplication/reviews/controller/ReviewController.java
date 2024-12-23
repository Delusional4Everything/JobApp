package com.ankit.JobApplication.reviews.controller;


import com.ankit.JobApplication.reviews.entity.Review;
import com.ankit.JobApplication.reviews.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview (@PathVariable Long companyId){
        List<Review> reviews =   reviewService.getAllReview(companyId);
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }
    @GetMapping("/getReviewById/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId){
        return new ResponseEntity<>
                (reviewService.getReviewById(companyId,reviewId),HttpStatus.OK);
    }

    @PostMapping("/saveReview")
    public ResponseEntity<String> saveReview( @PathVariable Long companyId , @RequestBody Review review){
        boolean isReviewSaved = reviewService.saveReview(companyId,review);
        if(isReviewSaved) {
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Review is not added",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("deleteReviewById/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id, @PathVariable Long companyId){
        boolean deleted = reviewService.deleteReviewById(id,companyId);
        if(deleted)
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review is not deleted ",HttpStatus.NOT_FOUND);

    }

    //update the review against any company
    @PutMapping("updateReviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long reviewId ,@PathVariable Long companyId, @RequestBody Review review){
        boolean updated = reviewService.updateReviewById(reviewId,companyId,review);
        if(updated)
            return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review is not updated", HttpStatus.NOT_FOUND);

    }

}
