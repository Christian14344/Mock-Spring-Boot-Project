<<<<<<< HEAD
package com.example.demo.repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByCompany_CompanyID(int companyID);
    Optional<Employee> findByCompany_CompanyIDAndId(int companyId, int employeeId);

}
=======
package com.example.demo.repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByCompany_CompanyID(int companyID);
    Optional<Employee> findByCompany_CompanyIDAndId(int companyId, int employeeId);

}
>>>>>>> 269c967 (updated files)
