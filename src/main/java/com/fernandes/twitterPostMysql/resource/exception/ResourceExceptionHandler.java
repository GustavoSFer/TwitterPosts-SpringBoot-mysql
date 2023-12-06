package com.fernandes.twitterPostMysql.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernandes.twitterPostMysql.service.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StanderdError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Não encontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderdError err = new StanderdError(Instant.now(), status.value(), error, "not found!!!", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
