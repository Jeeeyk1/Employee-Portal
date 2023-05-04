package com.example.EmployeePortal.EmployeesController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeePortal.CustomErrors.UserNotFoundException;
import com.example.EmployeePortal.EmployeesModel.EmployeeDTO;
import com.example.EmployeePortal.EmployeesModel.EmployeeModel;
import com.example.EmployeePortal.EmployeesModel.TimeInOutModel;
import com.example.EmployeePortal.EmployeesService.EmployeeService;
import com.example.EmployeePortal.TimeInOutEmployeeService.TimeInOutEmployeeService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	private final TimeInOutEmployeeService tioService;

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeesInformation() {
		List<EmployeeModel> employees = employeeService.getAllEmployeesInfo();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (EmployeeModel employee : employees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employee.getId());
			employeeDTO.setFirstname(employee.getFirstname());
			employeeDTO.setLastname(employee.getLastname());
			employeeDTO.setMiddlename(employee.getMiddlename());
			employeeDTO.setEmail(employee.getEmail());
			employeeDTO.setPosition(employee.getPosition());
			employeeDTO.setRatePerHour(employee.getRatePerHour());
			employeeDTO.setTimeInOuts(employee.getTimeInOuts());
			employeeDTOs.add(employeeDTO);
		}

		return ResponseEntity.ok(employeeDTOs);

	}

	@GetMapping("/timein")
	public List<TimeInOutModel> getAllTimeInOuts() {
		List<TimeInOutModel> response = tioService.getAllTimeInOuts();

		return response;
	}

	@PostMapping
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO dto) {
		employeeService.addEmployee(dto);
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable Long id) {
		EmployeeDTO res = new EmployeeDTO();
		res = employeeService.findEmployeeById(id);
		return ResponseEntity.ok(res);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", ex.getMessage());
		response.put("timestamp", new Date(0));

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
