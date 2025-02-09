package org.example.jobs.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews(@PathVariable int companyId) {
        return reviewService.getReviews(companyId);
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable int id) {
        return reviewService.getReview(id);
    }

    @PostMapping
    public String addReview(@PathVariable int companyId, @RequestBody Review review) {
        reviewService.saveReview(companyId, review);
        return "Review added successfully!";
    }

    @PutMapping("/{id}")
    public String updateReview(@PathVariable int companyId, @PathVariable int id, @RequestBody Review review) {
        reviewService.updateReview(companyId, id, review);
        return "Review updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully!";
    }
}
