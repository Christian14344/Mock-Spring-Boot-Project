package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.LogDetailsDTO;
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
import java.util.stream.Collectors;

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
    public List<LogDetailsDTO> getAllLogsByCompanyId(int compID) {

        companyRepo.findById(compID).orElseThrow(()-> new RuntimeException("company not found"));

        List<Log> logs = logsRepo.findAllLogsByCompanyId(compID);

        return logs.stream()
                .map(log -> new LogDetailsDTO(
                        log.getId(),
                        log.getTimeStamp(),
                        log.getLatitude(),
                        log.getLongitude(),
                        log.getEmployee().getId(),
                        log.getEmployee().getFirstName(),
                        log.getEmployee().getMiddleName(),
                        log.getEmployee().getLastName(),
                        log.getEmployee().getUserName()))
                .collect(Collectors.toList());
    }


    //    fetch logs from an employee
    public List<LogDetailsDTO> getEmployeeLogsToDTO(int compID, int empID){

        employeeRepo.findByCompany_CompanyIDAndId(compID, empID)
                .orElseThrow(()-> new RuntimeException("Employee not found in company"));

         List<Log> logs = logsRepo.findAllLogsByEmployeeAndCompany(compID, empID);

         return logs.stream()
                .map(log -> new LogDetailsDTO(
                        log.getId(),
                        log.getTimeStamp(),
                        log.getLatitude(),
                        log.getLongitude(),
                        log.getEmployee().getId(),
                        log.getEmployee().getFirstName(),
                        log.getEmployee().getMiddleName(),
                        log.getEmployee().getLastName(),
                        log.getEmployee().getUserName()))
                .collect(Collectors.toList());
    }


    //add logs from an employee
    public LogDetailsDTO sendLogs(int compID, int empID, Log log){
        Company company = companyRepo.findById(compID)
                .orElseThrow(() -> new RuntimeException("Company ID does not exist"));

        Employee employee = employeeRepo.findById(empID)
                .orElseThrow(() -> new RuntimeException("Employee ID does not exist"));

        employeeRepo.findByCompany_CompanyIDAndId(compID, empID)
                .orElseThrow(() -> new RuntimeException("Employee not found in company"));

        log.setEmployee(employee);

        logsRepo.save(log);
        return new LogDetailsDTO(
                log.getId(),
                log.getTimeStamp(),
                log.getLongitude(),
                log.getLatitude(),
                log.getEmployee().getId(),
                log.getEmployee().getFirstName(),
                log.getEmployee().getMiddleName(),
                log.getEmployee().getLastName(),
                log.getEmployee().getUserName()
        );
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
    
}
