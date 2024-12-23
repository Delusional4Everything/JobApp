package com.ankit.JobApplication.job.sevices;

import com.ankit.JobApplication.job.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getById(Long id);

    Boolean deleteById(Long id);

    Boolean udateById(Long id, Job job);
}
