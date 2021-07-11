package com.sezayir.UserDa;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.sezayir.model.User;

@Component
public class UserDao {
	
	Map<String,User> map= new HashMap<>();
	
	@PostConstruct
	public void init() {
		
		map.put("sezayir", new User("sezayir","Dağtekin"));
		map.put("cem", new User("cem","Ersoy"));
		
	}

	public boolean isUserExist(String username) {
		return map.containsKey(username);
	}
	

}
