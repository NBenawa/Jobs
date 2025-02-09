package org.example.jobs.review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(int companyId);
    Review getReview(int id);
    boolean saveReview(int companyId, Review review);
    boolean deleteReview(int id);
    boolean updateReview(int companyId, int id, Review review);
}
