package com.example.demo.controller;


import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //for fetching all employees
    @GetMapping("all")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    //for adding employee
    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    //for editing employee
    @PutMapping("edit/{empID}/{compID}")
    public ResponseEntity<Employee> editEmployee(@PathVariable String empID, String compID, @RequestBody Employee employee){
        return employeeService.updateEmployee(empID, compID, employee)
                .map(updatedEmployee -> new ResponseEntity<>(updatedEmployee, HttpStatus.ACCEPTED))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //delete employee
    @DeleteMapping("delete/{empID}")
    public String deleteEmployee(@PathVariable String empID){
        employeeService.deleteEmployee(empID);
        return "Successfully deleted";
    }


}
