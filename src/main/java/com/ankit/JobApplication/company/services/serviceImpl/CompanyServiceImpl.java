package com.ankit.JobApplication.company.services.serviceImpl;

import com.ankit.JobApplication.company.entity.Company;
import com.ankit.JobApplication.company.repository.CompanyRepo;
import com.ankit.JobApplication.company.services.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @Override
    public void saveCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public Boolean deleteByCompId(Long id) {
        try {
            companyRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateCompById(Long id, Company company) {
        Optional<Company> companyId = companyRepo.findById(id);
        if(companyId.isPresent()){
            Company company1 = companyId.get();
            company1.setDescription(company.getDescription());
            company1.setName(company.getName());
            company1.setJobs(company.getJobs());
            company1.setId(company.getId());
            companyRepo.save(company1);
            return true;
        }
        return false;
    }

}
