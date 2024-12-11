package com.ankit.JobApplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value = "api/" )
public class JobController {
    private final List<Job> jobs = new ArrayList<>();
    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobs;
    }

    @PostMapping("/createJob")
    public String createJob(@RequestBody Job job){
        jobs.add(job);
        return "job add successfully";
    }
}
