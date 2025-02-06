package com.example.demo.repository;

import com.example.demo.dto.LogDetailsDTO;
import com.example.demo.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogsRepo extends JpaRepository<Log, Integer> {
    @Query("SELECT l FROM Log l JOIN l.employee e WHERE e.company.companyID = :companyId")
    List<Log> findAllLogsByCompanyId(int companyId);

    // Fetch all logs for a specific employee within a specific company
    @Query("SELECT l FROM Log l JOIN l.employee e WHERE e.company.companyID = :companyId AND e.id = :employeeId")
    List<Log> findAllLogsByEmployeeAndCompany(int companyId, int employeeId);


}
