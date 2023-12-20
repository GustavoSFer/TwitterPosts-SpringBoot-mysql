package com.fernandes.twitterPostMysql.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernandes.twitterPostMysql.service.exception.DatabaseException;
import com.fernandes.twitterPostMysql.service.exception.NullPointerBadRequestException;
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

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StanderdError> userNotCreate(DatabaseException e, HttpServletRequest request) {
		String error = e.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StanderdError err = new StanderdError(Instant.now(), status.value(), error, "Não foi criado", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(NullPointerBadRequestException.class)
	public ResponseEntity<StanderdError> badRequestException(NullPointerBadRequestException e, HttpServletRequest request) {
		String error = e.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StanderdError err = new StanderdError(Instant.now(), status.value(), error, "Não foi criado", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
