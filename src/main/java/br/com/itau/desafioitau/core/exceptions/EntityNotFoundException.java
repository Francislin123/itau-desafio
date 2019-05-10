package br.com.itau.desafioitau.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by vn0y942 on 26/07/17.
 */
public class EntityNotFoundException extends UserException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getErrorCode() {
        return HttpStatus.NOT_FOUND;
    }
}
