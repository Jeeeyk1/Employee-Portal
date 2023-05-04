package com.example.EmployeePortal.Utils;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.EmployeePortal.CustomErrors.UserNotFoundException;
import com.example.EmployeePortal.EmployeeRepository.EmployeeRepository;
import com.example.EmployeePortal.EmployeesModel.EmployeeDTO;
import com.example.EmployeePortal.EmployeesModel.EmployeeModel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class EmployeeDTOMapper {
	private final EmployeeRepository repository;

	public EmployeeModel employeeDTOMapper(EmployeeDTO dto) {
		EmployeeModel mapped = new EmployeeModel();

		mapped.setEmail(dto.getEmail());
		mapped.setFirstname(dto.getFirstname());
		mapped.setLastname(dto.getLastname());
		mapped.setMiddlename(dto.getEmail());
		mapped.setPosition(dto.getPosition());
		mapped.setRatePerHour(dto.getRatePerHour());
		return mapped;

	}

	public EmployeeDTO findEmpById(Long id) {
		Optional<EmployeeModel> findEmp = repository.findById(id);
		EmployeeDTO dtoRes = new EmployeeDTO();

		if (findEmp.isPresent()) {
			dtoRes.setEmail(findEmp.get().getEmail());
			dtoRes.setFirstname(findEmp.get().getFirstname());
			dtoRes.setLastname(findEmp.get().getLastname());
			dtoRes.setId(id);
			dtoRes.setMiddlename(findEmp.get().getMiddlename());
			dtoRes.setPosition(findEmp.get().getPosition());
			dtoRes.setRatePerHour(findEmp.get().getRatePerHour());
		} else {
			throw new UserNotFoundException("User not found with ID:" + id);
		}
		return dtoRes;
	}

}
