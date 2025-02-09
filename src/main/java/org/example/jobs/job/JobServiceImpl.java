package org.example.jobs.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public boolean addJob(Job job) {
        jobRepository.save(job);
        return true;
    }

    @Override
    public List<Job> jobs() {
        return jobRepository.findAll();
    }

    @Override
    public boolean updateJob(int id, Job updatedJob) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJob(int id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Job getJob(int id) {
        return jobRepository.findById(id).orElse(null);
    }
}
