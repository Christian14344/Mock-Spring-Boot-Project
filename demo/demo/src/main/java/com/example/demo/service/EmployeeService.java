package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;


    public EmployeeService employeeService(){
        this.employeeRepo = employeeRepo;
        return employeeService();
    }

    //for fetching all employees
    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    //get a single employee
    public Employee getEmployeeByID(String employeeID){
        return employeeRepo.findById(employeeID).orElseThrow(()-> new RuntimeException("employee not found"));
    }

    //adding employee
    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    //edit employee details
    public Optional<Employee> updateEmployee(String employeeID, String companyID, Employee employeeEdit){
        return employeeRepo.findById(employeeID).map(employee ->{
            employee.setFirstName(employeeEdit.getFirstName());
            employee.setMiddleName(employeeEdit.getMiddleName());
            employee.setLastName(employeeEdit.getLastName());
            return employeeRepo.save(employee);
        });
    }

    //delete employee
    public void deleteEmployee(String employeeID){
        if(employeeRepo.existsById(employeeID)){
            employeeRepo.deleteById(employeeID);
        }else{
            throw new ServiceException("employee not found");
        }
    }

    public void addEmployeeWithCompID(Employee employee, int id) {
//        employeeRepo.save(employee);
//        Company company = employee.getCompany();
    }


}
