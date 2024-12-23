package com.ankit.JobApplication.company.repository;

import com.ankit.JobApplication.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
