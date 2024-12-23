package com.ankit.JobApplication.company.services;

import com.ankit.JobApplication.company.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
       List<Company> findAll();

       Company getById(Long id);

    void saveCompany(Company company);

    Boolean deleteByCompId(Long id);

    Boolean updateCompById(Long id, Company company);
}
