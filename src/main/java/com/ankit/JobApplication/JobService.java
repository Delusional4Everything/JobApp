package com.ankit.JobApplication;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getById(Long id);
}
