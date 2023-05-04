package com.example.EmployeePortal.EmployeeRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EmployeePortal.EmployeesModel.EmployeeDTO;
import com.example.EmployeePortal.EmployeesModel.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

	Optional<EmployeeModel> findByEmail(String email);
}
