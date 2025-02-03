package com.in10min.myfirstweb.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username,String password) {
		
		boolean isValidUsername = username.equalsIgnoreCase("in2min");
	    boolean isValidPassword = password.equalsIgnoreCase("dummy");
	    
	    return isValidPassword && isValidUsername;
	    
		
	}

}
