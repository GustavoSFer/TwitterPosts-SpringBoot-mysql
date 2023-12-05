package com.fernandes.twitterPostMysql.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Não foi encontrado o id informado: " + id);
	}

}
