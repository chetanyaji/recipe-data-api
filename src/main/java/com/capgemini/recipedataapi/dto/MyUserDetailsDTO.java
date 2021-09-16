package com.capgemini.recipedataapi.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.capgemini.recipedataapi.model.User;

public class MyUserDetailsDTO implements UserDetails {

	private static final long serialVersionUID = -3810928515997615631L;
	
	private String userName;
	private String password;
	private Boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetailsDTO() {
	}

	public MyUserDetailsDTO(User user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.getIsActive();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}
