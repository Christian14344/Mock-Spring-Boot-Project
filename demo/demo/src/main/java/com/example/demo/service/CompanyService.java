package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    public CompanyService companyService(){
        this.companyRepo = companyRepo;
        return companyService();
    }

    public List<Company> getCompanies(){
        return companyRepo.findAll();
    }

    public Company getCompany(int compID){
        return companyRepo.findById(compID).orElseThrow(()-> new RuntimeException("company not found"));
    }


    public Company addCompany(Company company){
        return companyRepo.save(company);
    }
}
