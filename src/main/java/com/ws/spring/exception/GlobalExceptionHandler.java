package com.ws.spring.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ws.common.util.ClientResponseUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LogManager.getLogger(this.getClass().getName());

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		logger.error("ResourceNotFoundException occured at {} and error is  {}", request.getContextPath(),
				ex.getMessage(), ex);
		ClientResponseBean response = ClientResponseUtil.getErrorResponse();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		logger.error("GlobleExcpetionHandler occured at {} and error is  {}", request.getContextPath(), ex.getMessage(),
				ex);
		ClientResponseBean response = ClientResponseUtil.getErrorResponse();
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @ExceptionHandler(UserDetailNotFoundException.class) public ResponseEntity<?>
	 * userDetailNotFoundExcpetionHandler(Exception ex, WebRequest request) {
	 * logger.error("GlobleExcpetionHandler occured at {} and error is  {}",
	 * request.getContextPath(), ex.getMessage(), ex); ClientResponseBean response =
	 * ClientResponseUtil.getUserDetailNotFoundResponse(); return new
	 * ResponseEntity<>(response, HttpStatus.NOT_FOUND); }
	 */
}
