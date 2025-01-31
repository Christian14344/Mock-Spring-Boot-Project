package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("all")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("{compID}")
    public Company getCompany(@PathVariable int compID){
        return companyService.getCompany(compID);
    }

    @PostMapping("add")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return new ResponseEntity<>(company, HttpStatus.ACCEPTED);
    }

    @PutMapping("edit/{id}")
    public Optional<Company> editCompany(@PathVariable int id, @RequestBody Company company){
        return companyService.editCompany(id, company);
    }

    @DeleteMapping("delete/{compID}")
    public String deleteCompany(@PathVariable int compID){
        companyService.deleteCompany(compID);
        return "Company "+compID+" deleted";
    }
}
