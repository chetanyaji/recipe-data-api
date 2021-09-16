package com.capgemini.recipedataapi.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.recipedataapi.dto.MyUserDetailsDTO;
import com.capgemini.recipedataapi.model.User;
import com.capgemini.recipedataapi.repository.UserRepository;

/**
 * This class contains UserDetailsService methods related to authentication.
 * 
 * @author chetasin
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LogManager.getLogger(MyUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;

	/**
	 * This method is use to load user by username from database.
	 * 
	 * @return UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("Invoke loadUserByUsername() method with username:{}", () -> username);
		Optional<User> user = userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		logger.debug("Exit from loadUserByUsername() method.");
		return user.map(MyUserDetailsDTO::new).get();
	}
}
