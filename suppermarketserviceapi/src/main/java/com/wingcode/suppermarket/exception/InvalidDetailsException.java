package com.wingcode.suppermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidDetailsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8326445097411879662L;

	public InvalidDetailsException() {
        super();
    }

    public InvalidDetailsException(String message) {
        super(message);
    }

    public InvalidDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
