package com.capgemini.recipedataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.capgemini.recipedataapi.dto.ErrorDetails;
import com.capgemini.recipedataapi.util.DateTimeLocal;

/**
 * All type of Exceptions and errors will be handled in this class
 * ExceptionHandlerPage
 * 
 * @author chetasin
 */
@ControllerAdvice
public class ExceptionHandlerPage {

	/**
	 * Returns Custom Exception Details Along with the status when a record is not
	 * found
	 * 
	 * @param exception - detailed message related to exception
	 * @param request   - request url details
	 * @return - custom exception details along with status NOT_FOUND
	 */
	@SuppressWarnings("unchecked")
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> toHandleResourceNotFound(ResourceNotFoundException exception, WebRequest request) {
		ErrorDetails error = new ErrorDetails(exception.getMessage(), request.getDescription(false),
				DateTimeLocal.getLocalDateTime());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * Returns Custom Exception Details Along with the status ,related to all custom
	 * exceptions
	 * 
	 * @param exception - detailed message related to exception
	 * @param request   - request url details
	 * @return - custom exception details along with status INTERNAL_SERVER_ERROR
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> toHandleAll(Exception exception, WebRequest request) {
		ErrorDetails error = new ErrorDetails(exception.getMessage(), request.getDescription(false),
				DateTimeLocal.getLocalDateTime());

		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Returns Custom Validation Details Along with the status
	 * 
	 * @param exception - detailed message related to exception
	 * @return - custom exception details along with status BAD_REQUEST
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> toHandleAllCustomValidations(MethodArgumentNotValidException exception) {
		ErrorDetails error = new ErrorDetails("Its a validation error",
				exception.getBindingResult().getFieldError().getField() + "--"
						+ exception.getBindingResult().getFieldError().getDefaultMessage(),
				DateTimeLocal.getLocalDateTime());

		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}

}
