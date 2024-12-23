package com.ankit.JobApplication.job.controller;

import com.ankit.JobApplication.job.entity.Job;
import com.ankit.JobApplication.job.repository.JobRepo;
import com.ankit.JobApplication.job.sevices.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "api/" )
public class JobController {
    private final JobRepo jobRepo;
    private final JobService jobService;

    public JobController(JobRepo jobRepo, JobService jobService) {
        this.jobRepo = jobRepo;
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id){
        Job job = jobService.getById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping("/createJob")
    public ResponseEntity<?> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("job add successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        Boolean deleted = jobService.deleteById(id);
        if(deleted)
            return new ResponseEntity<>("job deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PutMapping("updateById/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id , @RequestBody Job job){
        Boolean updated = jobService.udateById(id,job);
        if(updated)
            return new ResponseEntity<>("job Updated successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
