package com.ankit.JobApplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value = "api/" )
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @GetMapping("/job/{id}")
    public Job findById(@PathVariable Long id){
        Job job = jobService.getById(id);
        return job;
    }

    @PostMapping("/createJob")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "job add successfully";
    }

}
