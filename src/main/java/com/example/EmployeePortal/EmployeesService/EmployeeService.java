package com.example.EmployeePortal.EmployeesService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeePortal.CustomErrors.UserNotFoundException;
import com.example.EmployeePortal.EmployeeRepository.EmployeeRepository;
import com.example.EmployeePortal.EmployeesModel.EmployeeDTO;
import com.example.EmployeePortal.EmployeesModel.EmployeeModel;
import com.example.EmployeePortal.Utils.EmployeeDTOMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

	@Autowired
	private final EmployeeRepository employeeRepository;
	private final EmployeeDTOMapper mapper;

	public List<EmployeeModel> getAllEmployeesInfo() {

		return employeeRepository.findAll();
	}

	public void addEmployee(EmployeeDTO info) {
		EmployeeModel addEmployee = mapper.employeeDTOMapper(info);

		employeeRepository.save(addEmployee);
	}

	public EmployeeDTO findEmployeeById(Long id) {

		EmployeeDTO dtoRes = mapper.findEmpById(id);

		return dtoRes;

	}

}
