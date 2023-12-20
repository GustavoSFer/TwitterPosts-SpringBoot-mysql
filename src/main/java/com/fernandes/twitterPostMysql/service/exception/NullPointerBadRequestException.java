package com.fernandes.twitterPostMysql.service.exception;

public class NullPointerBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NullPointerBadRequestException() {}
	
	public NullPointerBadRequestException(String msg) {
		super(msg);
	}
}
