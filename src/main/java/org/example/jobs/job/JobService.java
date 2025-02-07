package org.example.jobs.job;

import java.util.List;

public interface JobService {
    boolean addJob(Job job);
    List<Job> jobs();
    boolean updateJob(int id, Job job);
    boolean deleteJob(int id);
}
