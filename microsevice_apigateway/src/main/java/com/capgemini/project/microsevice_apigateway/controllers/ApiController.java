package com.capgemini.project.microsevice_apigateway.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.capgemini.project.microsevice_apigateway.models.AuthenticationRequest;
import com.capgemini.project.microsevice_apigateway.models.AuthenticationResponse;
import com.capgemini.project.microsevice_apigateway.models.CommonMan;
import com.capgemini.project.microsevice_apigateway.services.MyUserDetailsService;
import com.capgemini.project.microsevice_apigateway.services.User1Service;
import com.capgemini.project.microsevice_apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ApiController {

	@Autowired
	private User1Service us;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@PostMapping("/adduser")
	public String addUsers(@RequestBody CommonMan c){
		return us.addUsers(c);
	}
}
