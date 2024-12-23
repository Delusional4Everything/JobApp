package com.ankit.JobApplication.reviews.entity;

import com.ankit.JobApplication.company.entity.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Review {
    @Id
    private Long id;
    private String title;
    private String description;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

}
