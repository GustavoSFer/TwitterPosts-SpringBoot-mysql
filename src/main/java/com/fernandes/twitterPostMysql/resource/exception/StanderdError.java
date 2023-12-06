package com.fernandes.twitterPostMysql.resource.exception;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StanderdError {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestemp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StanderdError() {		
	}
	
	public StanderdError(Instant timestemp, Integer status, String error, String message, String path) {
		super();
		this.timestemp = timestemp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(Instant timestemp) {
		this.timestemp = timestemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
