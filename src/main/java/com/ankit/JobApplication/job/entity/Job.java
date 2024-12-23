package com.ankit.JobApplication.job.entity;

import com.ankit.JobApplication.company.entity.Company;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Job {
    public Job() {
    }

    @Id
    private Long id;
    private String title;
    private String description;
    private String currentCtc;
    private String expectedCtc;
    private String location;

    @ManyToOne
    private Company company;




}
