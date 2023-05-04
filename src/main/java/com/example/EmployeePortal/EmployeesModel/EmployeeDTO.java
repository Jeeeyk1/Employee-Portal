package com.example.EmployeePortal.EmployeesModel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class EmployeeDTO {
	private Long id;

	private String firstname;

	private String lastname;

	private String middlename;
	private String email;
	private String position;

	private double ratePerHour;

	private List<TimeInOutModel> timeInOuts;
}
