package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Log;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.LogsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    LogsRepo logsRepo;

    public CompanyService companyService(){
        this.companyRepo = companyRepo;
        return companyService();
    }

    //get all companies
    public List<Company> getCompanies(){
        return companyRepo.findAll();
    }

    //get single company
    public Company getCompany(int compID){
        return companyRepo.findById(compID).orElseThrow(()-> new RuntimeException("company not found"));
    }

    //add company
    public Company addCompany(Company company){
        return companyRepo.save(company);
    }

    //edit company info
    public Optional<Company> editCompany(int compID, Company company) {
        return companyRepo.findById(compID).map(employee -> {
            employee.setCompanyID(company.getCompanyID());
            employee.setCompanyName(company.getCompanyName());
            return companyRepo.save(employee);
        });
    }

    //delete a company
    public void deleteCompany(int id){
        if (companyRepo.existsById(id)){
            companyRepo.deleteById(id);
        }else{
            throw new RuntimeException("company not found");
        }
    }

}
