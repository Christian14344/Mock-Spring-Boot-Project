package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("companies")
public class CompanyController {

    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //EMPLOYEES CONTROLLER
    //fetch all employees from a certain company
    @GetMapping("{companyId}/employees")
    public List<Employee> getEmployeesByCompany(@PathVariable int companyId) {
        return companyService.getEmployeesByCompanyId(companyId);
    }

    //fetch a single employee from a company
    @GetMapping("{companyId}/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int companyId, @PathVariable int employeeId) {
        return companyService.getEmployeeByCompany(companyId, employeeId);
    }

    //add an employee to a company
    @PostMapping("{companyId}/employees/")
    public ResponseEntity<Employee> addEmployee(@PathVariable int companyId, @RequestBody Employee employee){
        companyService.addEmployee(companyId, employee);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }


    //edit an employee from a company
    @PutMapping("{companyId}/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int companyId, @PathVariable int employeeId, @RequestBody Employee updatedEmployee) {
        return companyService.updateEmployeeDetails(companyId, employeeId, updatedEmployee);
    }

    //delete an employee from a company
    @DeleteMapping("{companyId}/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int companyId, @PathVariable int employeeId){
        companyService.deleteEmployee(companyId, employeeId);
        return "Employee no: "+employeeId+" deleted";
    }



    //COMPANY CONTROLLER
    //fetch all companies
    @GetMapping()
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    //fetch a single company
    @GetMapping("{compID}")
    public Company getCompany(@PathVariable int compID){
        return companyService.getCompany(compID);
    }

    //add a new company
    @PostMapping()
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return new ResponseEntity<>(company, HttpStatus.ACCEPTED);
    }

    //edit company
    @PutMapping("{compID}")
    public Optional<Company> editCompany(@PathVariable int compID, @RequestBody Company company){
        return companyService.editCompany(compID, company);
    }

    //delete a company
    @DeleteMapping("{compID}")
    public String deleteCompany(@PathVariable int compID){
        companyService.deleteCompany(compID);
        return "Company "+compID+" deleted";
    }
}
