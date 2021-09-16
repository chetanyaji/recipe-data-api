package com.capgemini.recipedataapi.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capgemini.recipedataapi.filter.JwtRequestFilter;

/**
 * This class containing Security configuration related method.
 * 
 * @author chetasin
 *
 */
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LogManager.getLogger(SecurityConfigurer.class);

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.debug("Invoke configure() with AuthenticationManagerBuilder method.");
		auth.userDetailsService(userDetailsService);
		logger.debug("Exit from configure() method.");
	}

	/**
	 * This configure method is used to bypass URL h2 database and authenticate. 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Invoke configure() with HttpSecurity method.");
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll().antMatchers("/h2-console/**").permitAll()
				.antMatchers("/authenticate").permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		logger.debug("Exit from configure() method.");
	}
	
	/**
	 * This method is used to generate AuthenticationManager.
	 * @return AuthenticationManager
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * This method is for PasswordEncoder.
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
