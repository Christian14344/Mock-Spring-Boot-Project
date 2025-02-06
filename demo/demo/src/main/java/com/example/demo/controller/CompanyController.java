package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.LogDetailsDTO;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Log;
import com.example.demo.service.CompanyService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("companies")
public class CompanyController {

    private final CompanyService companyService;

    private final EmployeeService employeeService;

    private final LogService logService;


    public CompanyController(CompanyService companyService, EmployeeService employeeService, LogService logService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.logService = logService;
    }

    //EMPLOYEES CONTROLLER
    //fetch all employees from a certain company
    @GetMapping("{companyId}/employees")
    public List<EmployeeDTO> getEmployeesByCompany(@PathVariable int companyId) {
        return employeeService.getEmployeesByCompanyId(companyId);
    }

    //fetch a single employee from a company
    @GetMapping("{companyId}/employees/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable int companyId, @PathVariable int employeeId) {
        return employeeService.getEmployeeByCompany(companyId, employeeId);
    }

    //add an employee to a company
    @PostMapping("{companyId}/employees/")
    public ResponseEntity<EmployeeDTO> addEmployee(@PathVariable int companyId, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(companyId, employee), HttpStatus.ACCEPTED);
    }


    //edit an employee from a company
    @PutMapping("{companyId}/employees/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable int companyId, @PathVariable int employeeId, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployeeDetails(companyId, employeeId, updatedEmployee);
    }

    //delete an employee from a company
    @DeleteMapping("{companyId}/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int companyId, @PathVariable int employeeId){
        employeeService.deleteEmployee(companyId, employeeId);
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


    //CONTROLLER FOR LOGS
    //get all logs from a company
    @GetMapping("{compID}/logs")
    public List<LogDetailsDTO> fetchLogs(@PathVariable int compID){
        return logService.getAllLogsByCompanyId(compID);
    }

    //get a certain employee logs
    @GetMapping("{compID}/employees/{empID}/logs")
    public List<LogDetailsDTO> fetchEmployeeLogs(@PathVariable int compID, @PathVariable int empID){
        return  logService.getEmployeeLogsToDTO(compID, empID);
    }

    //send logs from an employee
    @PostMapping("{compID}/employees/{empID}/logs")
    public ResponseEntity<LogDetailsDTO> sendLog(@PathVariable int compID, @PathVariable int empID, @RequestBody Log log){
        return new ResponseEntity<>(logService.sendLogs(compID, empID, log),HttpStatus.ACCEPTED);
    }


    //delete log instance from an employee
    @DeleteMapping("{compID}/employees/{empID}/logs/{logID}")
    public ResponseEntity<String> deleteLog(@PathVariable int compID, @PathVariable int empID, @PathVariable int logID){
        logService.deleteLog(compID, empID, logID);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }


}
