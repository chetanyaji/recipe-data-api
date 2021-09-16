package com.capgemini.recipedataapi.dto;

/**
 * Data Fields are added related to custom Exceptions, message, timeStamp
 * 
 * @author chetasin
 */

public class ErrorDetails {

	private String message;
	private String details;
	private String timeStamp;

	/**
	 * Default constructor
	 */
	public ErrorDetails() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param message
	 * @param details
	 * @param timeStamp
	 */
	public ErrorDetails(String message, String details, String timeStamp) {
		super();
		this.message = message;
		this.details = details;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorDetails [message=");
		builder.append(message);
		builder.append(", details=");
		builder.append(details);
		builder.append(", timeStamp=");
		builder.append(timeStamp);
		builder.append("]");
		return builder.toString();
	}

}
