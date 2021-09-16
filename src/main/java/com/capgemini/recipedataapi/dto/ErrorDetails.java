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

	public ErrorDetails() {
	}

	public ErrorDetails(String message, String details, String timeStamp) {
		super();
		this.message = message;
		this.details = details;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

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
