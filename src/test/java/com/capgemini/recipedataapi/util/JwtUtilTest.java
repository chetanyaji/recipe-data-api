package com.capgemini.recipedataapi.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.recipedataapi.dto.MyUserDetailsDTO;
import com.capgemini.recipedataapi.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JwtUtilTest {

	@InjectMocks
	private JwtUtil jwtUtil;

	@Test
	public void generateToken() {
		User user = new User(Long.valueOf("1"), "pass", "Admin", true, "admin");
		String token = jwtUtil.generateToken(new MyUserDetailsDTO(user));
		assertNotNull(token);
		assertNotNull(jwtUtil.extractUsername(token));
		assertTrue(jwtUtil.validateToken(token, new MyUserDetailsDTO(user)));
	}
}
