package com.capgemini.recipedataapi.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.recipedataapi.model.User;
import com.capgemini.recipedataapi.repository.UserRepository;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class MyUserDetailsServiceTest {

//	@InjectMocks
//	private MyUserDetailsService myUserDetailsService;
//
//	@Mock
//	private UserRepository userRepository;
//
//	@Test
//	@WithUserDetails("user")
//	public void loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<User> user = Optional.of(new User(Long.valueOf("1"), "user", "pass", true, "USER,ADMIN"));
//		when(userRepository.findByUserName(Mockito.anyString())).thenReturn(user);
//		UserDetails userDetails = myUserDetailsService.loadUserByUsername("user");
//		assertNotNull(userDetails);
//	}
}
