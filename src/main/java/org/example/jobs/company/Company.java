package org.example.jobs.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.jobs.job.Job;
import org.example.jobs.review.Review;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany (mappedBy = "company")
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany (mappedBy = "company")
    @JsonIgnore
    private List<Job> jobs;

    public Company() {
    }

    public Company(String name, List<Review> reviewList) {
        this.name = name;
        this.reviews = reviews;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
