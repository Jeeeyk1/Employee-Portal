package com.example.EmployeePortal.AuthenticationController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeePortal.AuthenticationModel.AuthenticationRequest;
import com.example.EmployeePortal.AuthenticationModel.AuthenticationResponse;
import com.example.EmployeePortal.AuthenticationModel.RegisterRequest;
import com.example.EmployeePortal.AuthenticationService.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	private final AuthenticationService service;
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(service.register(request));
		
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
		
		return ResponseEntity.ok(service.authenticate(request));
	}
}
