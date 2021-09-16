package com.capgemini.recipedataapi.filter;

import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.recipedataapi.dto.MyUserDetailsDTO;
import com.capgemini.recipedataapi.model.User;
import com.capgemini.recipedataapi.util.JwtUtil;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JwtRequestFilterTest{
	
	@InjectMocks
	private JwtRequestFilter jwtRequestFilter;
	
	@Mock
	private UserDetailsService myUserDetailsService;

	@Mock
	private JwtUtil jwtUtil;
	
	@Test
	public void doFilterInternalTest() throws IOException, ServletException{
		User user = new User();
		user.setId(Long.valueOf("1"));
		user.setIsActive(true);
		user.setPassword("pass");
		user.setRoles("Admin");
		user.setUserName("admin");
		UserDetails UserDetails = new MyUserDetailsDTO(user);
		MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
		MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
		MockFilterChain filterChain = new MockFilterChain();
		httpServletRequest.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYzMTcyOTM3NSwiaWF0IjoxNjMxNzI4MTc1fQ.uVlW9uX0A10AlHHdCLJUIO_lqLjAZpnKzvXitXFvYc0");
		when(jwtUtil.extractUsername(Mockito.anyString())).thenReturn("user");
		when(myUserDetailsService.loadUserByUsername(Mockito.anyString())).thenReturn(UserDetails);
		when(jwtUtil.validateToken(Mockito.anyString(), Mockito.any())).thenReturn(true);
		jwtRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
	}
	
}
