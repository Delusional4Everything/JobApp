package com.ankit.JobApplication;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Optional<Job> getById(Long id);

    Boolean deleteById(Long id);

    Boolean udateById(Long id, Job job);
}
