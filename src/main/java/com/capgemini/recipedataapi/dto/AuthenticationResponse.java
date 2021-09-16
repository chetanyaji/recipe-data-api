package com.capgemini.recipedataapi.dto;

/**
 * This DTO class containing data members related to authentication response.
 * 
 * @author chetasin
 */
public class AuthenticationResponse {

	private final String jwt;

	/**
	 * Parameterized constructor
	 * 
	 * @param jwt
	 */
	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

}
