package com.capgemini.recipedataapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.recipedataapi.dto.MyUserDetailsDTO;
import com.capgemini.recipedataapi.model.AuthenticationRequest;
import com.capgemini.recipedataapi.model.AuthenticationResponse;
import com.capgemini.recipedataapi.model.User;
import com.capgemini.recipedataapi.util.JwtUtil;

/**
 * This class contains JUnit test cases for AuthenticationController.java
 * 
 * @author chetasin
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthenticationControllerTest {
	
	@InjectMocks
	private AuthenticationController authenticationController;
	
	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private UserDetailsService myUserDetailsService;

	@Mock
	private JwtUtil jwtUtil;
	
	@Test
	public void createAuthenticationTokenTest() throws Exception {
		User user = new User();
		user.setId(Long.valueOf("1"));
		user.setIsActive(true);
		user.setPassword("pass");
		user.setRoles("Admin");
		user.setUserName("admin");
		user.getId();
		user.getIsActive();
		user.getPassword();
		user.getRoles();
		user.getUserName();
		new MyUserDetailsDTO();
		MyUserDetailsDTO myUserDetailsDTO = new MyUserDetailsDTO(user);
		myUserDetailsDTO.getAuthorities();
		myUserDetailsDTO.getPassword();
		myUserDetailsDTO.getUsername();
		myUserDetailsDTO.isAccountNonExpired();
		myUserDetailsDTO.isAccountNonLocked();
		myUserDetailsDTO.isCredentialsNonExpired();
		myUserDetailsDTO.isEnabled();
		new AuthenticationResponse("Test").getJwt();
		AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
		authenticationRequest1.setUsername("admin");
		authenticationRequest1.setPassword("pass");
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "pass");
		when(myUserDetailsService.loadUserByUsername(Mockito.anyString())).thenReturn(myUserDetailsDTO);
		when(jwtUtil.generateToken(Mockito.any())).thenReturn(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYzMTY5NDg3NiwiaWF0IjoxNjMxNjkzNjc2fQ.9VkKPQ2xSTwvO3opk3Q-3lYJmQ7BVaMZCZ_OBb4J6VM");
		ResponseEntity<?> responseEntity = authenticationController.createAuthenticationToken(authenticationRequest);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	@Test
	public void authenticationTokenBadTest() throws Exception {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "pass");
		when(authenticationManager.authenticate(Mockito.any())).thenThrow(BadCredentialsException.class);
		assertThrows(Exception.class, () -> {
			authenticationController.createAuthenticationToken(authenticationRequest);
		  });
	}
}
