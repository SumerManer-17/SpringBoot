package com.example.securityApplication.SecurityApp;

import com.example.securityApplication.SecurityApp.entities.User;
import com.example.securityApplication.SecurityApp.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityAppApplicationTests {
	@Autowired
	private JwtService jwtService;
	@Test
	void contextLoads() {

		User user=new User(101L,"sumer@gmail.com","123321");

		String token= jwtService.generateToken(user);

		System.out.println(token);

		Long id= jwtService.getUserIdFromToken(token);

		System.out.println(id);

	}

}
