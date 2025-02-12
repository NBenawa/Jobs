package org.example.jobs.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> jobs() {
        List<Job> jobs = jobService.jobs();
        return ResponseEntity.ok(jobs);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.addJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body("Job created successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable int id, @RequestBody Job job) {
        boolean updated = jobService.updateJob(id, job);
        if (updated) {
            return ResponseEntity.ok("Job updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        boolean deleted = jobService.deleteJob(id);
        if (deleted) {
            return ResponseEntity.ok("Job deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable int id) {
        Job job = jobService.getJob(id);
        return job != null ? ResponseEntity.ok(job) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}