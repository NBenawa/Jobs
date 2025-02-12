package org.example.jobs.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(@PathVariable int companyId) {
        List<Review> reviews = reviewService.getReviews(companyId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable int id) {
        Review review = reviewService.getReview(id);
        return review != null ? ResponseEntity.ok(review) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<String> addReview(@PathVariable int companyId, @RequestBody Review review) {
        reviewService.saveReview(companyId, review);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review added successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable int companyId, @PathVariable int id, @RequestBody Review review) {
        boolean updated = reviewService.updateReview(companyId, id, review);
        if (updated) {
            return ResponseEntity.ok("Review updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable int id) {
        boolean deleted = reviewService.deleteReview(id);
        if (deleted) {
            return ResponseEntity.ok("Review deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found!");
        }
    }
}