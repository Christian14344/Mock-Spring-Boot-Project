package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    CompanyRepo companyRepo;

    //ALL RELATED TO EMPLOYEES

    //FETCH ALL EMPLOYEES FROM A COMPANY
    public List<EmployeeDTO> getEmployeesByCompanyId(int companyId) {

        List<Employee> employees = employeeRepo.findByCompany_CompanyID(companyId);

        // Convert the list of Employee entities to a list of EmployeeDTOs (without passwords)
        return employees.stream()
                .map(employee -> new EmployeeDTO(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getLastName(),
                        employee.getUserName(),
                        employee.getCompany()))
                .collect(Collectors.toList());
    }

    //FETCH A SINGLE EMPLOYEE FROM A COMPANY
    public EmployeeDTO getEmployeeByCompany(int companyId, int employeeId) {
        Employee employee =  employeeRepo.findByCompany_CompanyIDAndId(companyId, employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getUserName(),
                employee.getCompany()
        );
    }

    //ADD AN EMPLOYEE FOR A COMPANY
    public EmployeeDTO addEmployee(int companyId, Employee employee) {

        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company ID does not exist"));

        if (employee.getPassword() == null || employee.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        employee.setCompany(company);
        employeeRepo.save(employee);
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getUserName(),
                employee.getCompany()
        );
    }


    //EDIT INFORMATION OF AN EMPLOYEE
    public EmployeeDTO updateEmployeeDetails(int companyId, int employeeId, Employee updatedEmployee) {
        Employee employeeUpdatedDetails = employeeRepo.findByCompany_CompanyIDAndId(companyId, employeeId)
                .orElseThrow(()-> new RuntimeException("Employee not found in company"));

        employeeUpdatedDetails.setFirstName(updatedEmployee.getFirstName());
        employeeUpdatedDetails.setMiddleName(updatedEmployee.getMiddleName());
        employeeUpdatedDetails.setLastName(updatedEmployee.getLastName());
        employeeUpdatedDetails.setUserName(updatedEmployee.getUserName());
        employeeUpdatedDetails.setPassword(updatedEmployee.getPassword());

        employeeRepo.save(employeeUpdatedDetails);

        return new EmployeeDTO(
                employeeUpdatedDetails.getId(),
                employeeUpdatedDetails.getFirstName(),
                employeeUpdatedDetails.getMiddleName(),
                employeeUpdatedDetails.getLastName(),
                employeeUpdatedDetails.getUserName(),
                employeeUpdatedDetails.getCompany()
        );
    }


    //DELETE AN EMPLOYEE FROM COMPANY
    public void deleteEmployee(int companyId, int employeeId) {
        // Fetch the employee by company ID and employee ID
        employeeRepo.findByCompany_CompanyIDAndId(companyId, employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        // Save the updated employee
        employeeRepo.deleteById(employeeId);
    }

}
