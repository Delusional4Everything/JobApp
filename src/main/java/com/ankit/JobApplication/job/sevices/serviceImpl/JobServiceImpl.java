package com.ankit.JobApplication.job.sevices.serviceImpl;


import com.ankit.JobApplication.job.entity.Job;
import com.ankit.JobApplication.job.repository.JobRepo;
import com.ankit.JobApplication.job.sevices.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class JobServiceImpl implements JobService {
    Long nextInd= 0L;
    private final JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    //private final List<Job> jobs = new ArrayList<>();


    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextInd++);
        jobRepo.save(job);


    }

    @Override
    public Job getById(Long id) {
       return jobRepo.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            jobRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public Boolean udateById(Long id, Job updatedjob) {
        Optional<Job> jobOptional = jobRepo.findById(id);
            if(jobOptional.isPresent()){
                Job job = jobOptional.get();

                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setCurrentCtc(updatedjob.getCurrentCtc());
                job.setExpectedCtc(updatedjob.getExpectedCtc());
                job.setLocation(updatedjob.getLocation());
                return true;
            }

        return false;
    }
}
