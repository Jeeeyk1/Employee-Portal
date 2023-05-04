package com.example.EmployeePortal.EmployeesModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TimeInOutDTO {
	private Long id;
	private String timeIn;
	private String timeOut;
}
