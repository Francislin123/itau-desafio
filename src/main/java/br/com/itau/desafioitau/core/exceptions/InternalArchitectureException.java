package br.com.itau.desafioitau.core.exceptions;

import org.springframework.http.HttpStatus;

public abstract class InternalArchitectureException extends RuntimeException {

    public InternalArchitectureException(String message) {
        super(message);
    }

    public InternalArchitectureException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getErrorCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
