package com.sezayir.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sezayir.UserDa.UserDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao  userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (userDao.isUserExist(username)) {
			//Encode decodo password 
			//https://bcrypt-generator.com/
			return new User(username, "$2y$12$p8xUBQVhVVARPjAM7BWGXuMM/nb4b5XcDyHUXggOzLG3C2tpuC/ES",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}