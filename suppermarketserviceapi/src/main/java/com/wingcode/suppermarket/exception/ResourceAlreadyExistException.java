package com.wingcode.suppermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class ResourceAlreadyExistException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8326445097411879662L;

	public ResourceAlreadyExistException() {
        super();
    }
	
    public ResourceAlreadyExistException(String message) {
        super(message);
    }

    public ResourceAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
