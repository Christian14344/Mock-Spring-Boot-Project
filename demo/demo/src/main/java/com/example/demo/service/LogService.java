package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Log;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.LogsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    LogsRepo logsRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    CompanyRepo companyRepo;

    //GET ALL LOGS FROM A COMPANY
    // Fetch all logs from all employees of a specific company
    public List<Log> getAllLogsByCompanyId(int companyId) {
        return logsRepo.findAllLogsByCompanyId(companyId);
    }

    //fetch logs from an employee
    public List<Log> getEmployeeLogs(int compID, int empID) {
        return logsRepo.findAllLogsByEmployeeAndCompany(compID, empID);
    }

    //add logs from an employee
    public void sendLogs(int compID, int empID, Log log){
        Company company = companyRepo.findById(compID)
                .orElseThrow(() -> new RuntimeException("Company ID does not exist"));

        Employee employee = employeeRepo.findById(empID)
                .orElseThrow(() -> new RuntimeException("Employee ID does not exist"));

        employeeRepo.findByCompany_CompanyIDAndId(compID, empID)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        log.setEmployee(employee);

        logsRepo.save(log);
    }

    //delete a log from an employee
    public void deleteLog(int compID, int empID, int logID) {
        Company company = companyRepo.findById(compID)
                .orElseThrow(() -> new RuntimeException("Company ID does not exist"));

        Employee employee = employeeRepo.findById(empID)
                .orElseThrow(() -> new RuntimeException("Employee ID does not exist"));

        employeeRepo.findByCompany_CompanyIDAndId(compID, empID)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        Log log = logsRepo.findById(logID)
                .orElseThrow(()-> new RuntimeException("Log ID does not exist"));

        logsRepo.deleteById(logID);
    }


    public Optional<Log> fetchSingleLogByEmployee(int compID, int empID, int logID) {

        logsRepo.findById(logID)
                .orElseThrow(()-> new RuntimeException("Log ID does not exist"));

        companyRepo.findById(compID)
                .orElseThrow(() -> new RuntimeException("Company ID does not exist"));

        employeeRepo.findByCompany_CompanyIDAndId(compID, empID)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        return logsRepo.findById(logID);
    }
}
