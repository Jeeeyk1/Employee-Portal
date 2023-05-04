package com.example.EmployeePortal.TimeInOutEmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeePortal.EmployeeRepository.EmployeeTIORepository;
import com.example.EmployeePortal.EmployeesModel.TimeInOutModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimeInOutEmployeeService {

	private final EmployeeTIORepository repository;

	public List<TimeInOutModel> getAllTimeInOuts() {
		return repository.findAll();
	}

}
