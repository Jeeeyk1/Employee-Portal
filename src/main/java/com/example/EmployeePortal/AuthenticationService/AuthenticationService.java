package com.example.EmployeePortal.AuthenticationService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EmployeePortal.AuthenticationModel.AuthenticationRequest;
import com.example.EmployeePortal.AuthenticationModel.AuthenticationResponse;
import com.example.EmployeePortal.AuthenticationModel.RegisterRequest;
import com.example.EmployeePortal.Config.JwtService;
import com.example.EmployeePortal.EmployeeRepository.EmployeeRepository;
import com.example.EmployeePortal.EmployeesModel.EmployeeModel;
import com.example.EmployeePortal.EmployeesModel.Role;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class AuthenticationService {
	private final EmployeeRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		var user = EmployeeModel.builder().firstname(request.getFirstname()).lastname(request.getLastname())
				.email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.EMP)
				.build();
		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		var user = repository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
}
