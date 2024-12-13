package com.ankit.JobApplication;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Job {
    public Job() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String currentCtc;
    private String expectedCtc;
    private String location;
    @Version
    private Long version;



}
