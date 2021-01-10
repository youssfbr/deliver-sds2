package com.alissondev.deliver.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alissondev.deliver.services.exceptions.ResourceNotNull;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
		
	@ExceptionHandler(ResourceNotNull.class)
	public ResponseEntity<StandardError> asd(ResourceNotNull e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());		
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}	
}
