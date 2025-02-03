package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    EmployeeRepo employeeRepo;

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


    //ALL RELATED TO EMPLOYEES

    //FETCH ALL EMPLOYEES FROM A COMPANY
    public List<Employee> getEmployeesByCompanyId(int companyId) {
        return employeeRepo.findByCompany_CompanyID(companyId);
    }

    //FETCH A SINGLE EMPLOYEE FROM A COMPANY
    public Employee getEmployeeByCompany(int companyId, int employeeId) {
        return employeeRepo.findByCompany_CompanyIDAndId(companyId, employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));
    }

    //ADD AN EMPLOYEE FOR A COMPANY
    public void addEmployee(int companyId, Employee employee) {

        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company ID does not exist"));

        employee.setCompany(company);
        // Save the employee
        Employee savedEmployee = employeeRepo.save(employee);

    }


    //EDIT INFORMATION OF AN EMPLOYEE
    public Employee updateEmployeeDetails(int companyId, int employeeId, Employee updatedEmployee) {
        // Fetch the employee by company ID and employee ID
        Employee employee = employeeRepo.findByCompany_CompanyIDAndId(companyId, employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        // Update employee details (assuming firstName, middleName, and lastName are the editable fields)
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setMiddleName(updatedEmployee.getMiddleName());
        employee.setLastName(updatedEmployee.getLastName());

        // Save the updated employee
        return employeeRepo.save(employee);
    }

    //DELETE AN EMPLOYEE FROM COMPANY
    public void deleteEmployee(int companyId, int employeeId) {
        // Fetch the employee by company ID and employee ID
        Employee employee = employeeRepo.findByCompany_CompanyIDAndId(companyId, employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        // Save the updated employee
        employeeRepo.deleteById(employeeId);
    }

}
