package com.personal.todolist.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Security {
//InMemoryUserDetailsManager 
//InMemoryUserDetailsManager (UserDetails...users)
@Bean
public InMemoryUserDetailsManager createUser() {
	

	UserDetails userDetails1 = createUser("varun", "123");
	UserDetails userDetails2 = createUser("varun1", "1234");
	
	return new InMemoryUserDetailsManager (userDetails1,userDetails2);
}
private UserDetails createUser(String username, String password) {
	Function<String, String> passwordEncoder=
			input->passwordEncoder().encode(input);
	
	UserDetails userDetails=User.builder().passwordEncoder(passwordEncoder)
			.username(username)
			.password(password)
			.roles("USER","ADMIN")
			.build();
	return userDetails;
}
@Bean
public PasswordEncoder passwordEncoder() {
	
	return new BCryptPasswordEncoder();
}



}
