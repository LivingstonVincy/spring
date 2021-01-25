package com.example.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private AuthenticationManager auth;

	@Autowired
	private MyUserDetailsService service;

	@Autowired
	private JwtUtil util;

	@GetMapping("hi")
	public String hi() {
		return "Hello";
	}

	@PostMapping("authenticate")
	public String authenticate(@RequestBody AuthenticationRequest request) throws Exception {

		// 1. Authenticate based on username, password
		try {
			auth.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("User not found", e);
		}

		// 2. Get UserDetails
		UserDetails userDetails = service.loadUserByUsername(request.getUsername());

		// 3. Generate token based on userdetails
		String token = util.generateToken(userDetails);

		return token;
	}
}
