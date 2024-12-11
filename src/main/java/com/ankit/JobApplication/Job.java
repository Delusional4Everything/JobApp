package com.ankit.JobApplication;

import lombok.Data;

@Data
public class Job {
    private Long id;
    private String title;
    private String description;
    private String currentCtc;
    private String expectedCtc;
    private String location;


    public Job(long l, String testJob, String testJob1, String xx, String xx1, String unknown) {
    }
}
