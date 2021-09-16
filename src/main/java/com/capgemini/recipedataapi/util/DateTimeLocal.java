package com.capgemini.recipedataapi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Get Local date time from this class
 * 
 * @author chetasin
 */

public class DateTimeLocal {

	/**
	 * Returns Local date and time in this method
	 * 
	 * @return - local date and time will be returned in the format of dd-MM-yyyy
	 *         HH:mm
	 * 
	 */
	public DateTimeLocal() {
	}

	/**
	 * This method is use to get local date time in 'dd-MM-yyyy HH:mm' format.
	 * 
	 * @return String
	 */
	public static String getLocalDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return dateTime.format(formatter);
	}

}
