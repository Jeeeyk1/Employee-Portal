package com.example.EmployeePortal.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.EmployeePortal.EmployeeRepository.EmployeeRepository;
import com.example.EmployeePortal.EmployeeRepository.EmployeeTIORepository;
import com.example.EmployeePortal.EmployeesModel.EmployeeModel;
import com.example.EmployeePortal.EmployeesModel.Role;
import com.example.EmployeePortal.EmployeesModel.TimeInOutModel;

@Configuration
public class EmployeeConfig {

	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository repository, EmployeeTIORepository timeInOutRepository) {
		return args -> {
			EmployeeModel jake = new EmployeeModel(1L, "Justin Jake", "Almariego", "Lajo", "saitamasei@yahoo.com", null,
					"Java Developer", Role.EMP, 1500.00, null);
			jake = repository.save(jake); // save the EmployeeModel object first and get the generated ID
			List<TimeInOutModel> jakeTio = new ArrayList<>();
			TimeInOutModel timeInOutModel = new TimeInOutModel(1L, "2023-05-01T12:08:00", "2023-05-01T12:10:00", null,
					null, null, jake);
			jakeTio.add(timeInOutModel);
			jake.setTimeInOuts(jakeTio);
			timeInOutRepository.save(timeInOutModel);
			repository.save(jake);
		};
	}

}
