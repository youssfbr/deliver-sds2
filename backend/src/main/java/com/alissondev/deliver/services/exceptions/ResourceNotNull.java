package com.alissondev.deliver.services.exceptions;

public class ResourceNotNull extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotNull(String message) {
		super(message);
	}

}
