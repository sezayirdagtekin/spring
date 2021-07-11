package com.sezayir.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sezayir.request.JwtRequest;
import com.sezayir.response.JwtResponse;
import com.sezayir.service.JwtUserDetailsService;
import com.sezayir.utiltoken.JwtUtils;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager autManager;

	@Autowired
	private JwtUtils jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService jwtService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception {

		authenticate(authRequest.getUsername(), authRequest.getPassword());
		final UserDetails userDetails = jwtService.loadUserByUsername(authRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) {

		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		autManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

	}

}
