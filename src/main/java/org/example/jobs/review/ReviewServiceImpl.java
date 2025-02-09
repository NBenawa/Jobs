package org.example.jobs.review;

import org.example.jobs.company.Company;
import org.example.jobs.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getReviews(int companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review getReview(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public boolean saveReview(int companyId, Review review) {
        Company company = companyService.getCompany(companyId);
        review.setCompany(company);
        reviewRepository.save(review);
        return true;
    }

    @Override
    public boolean deleteReview(int id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(int companyId, int id, Review updatedReview) {
        Company company = companyService.getCompany(companyId);
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            review.setCompany(updatedReview.getCompany());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setTitle(updatedReview.getTitle());
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }
}
