package com.ankit.JobApplication.company.contoller;

import com.ankit.JobApplication.company.entity.Company;
import com.ankit.JobApplication.company.services.CompanyService;
import com.ankit.JobApplication.job.entity.Job;
import com.ankit.JobApplication.reviews.entity.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/allCompany")
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id){
        Company company = companyService.getById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PostMapping("/saveCompany")
    public ResponseEntity<?> saveCompany(@RequestBody Company company){
        companyService.saveCompany(company);
        return new ResponseEntity<>("job add successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteCompById(@PathVariable Long id){
        Boolean deleted = companyService.deleteByCompId(id);
        if(deleted)
            return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PutMapping("updateById/{id}")
    public ResponseEntity<String> updateCompById(@PathVariable Long id , @RequestBody Company company){
        Boolean updated = companyService.updateCompById(id,company);
        if(updated)
            return new ResponseEntity<>("Company Updated successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
