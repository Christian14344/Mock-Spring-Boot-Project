package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, String> {
    Optional<Employee> findByCompanyIdAndId(Long companyId, Long id);
}
