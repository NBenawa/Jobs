package org.example.jobs.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> jobs() {
        return jobService.jobs();
    }

    @PostMapping
    public String createJob(@RequestBody Job job) {
        jobService.addJob(job);
        return "Job created successfully!";
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable int id, @RequestBody Job job) {
        jobService.updateJob(id, job);
        return "Job updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable int id) {
        jobService.deleteJob(id);
        return "Job deleted successfully!";
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable int id) {
        return jobService.getJob(id);
    }
}
