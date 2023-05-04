package com.example.EmployeePortal.EmployeeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeePortal.EmployeesModel.TimeInOutModel;
@Repository
public interface EmployeeTIORepository extends JpaRepository<TimeInOutModel, Long> {

}
