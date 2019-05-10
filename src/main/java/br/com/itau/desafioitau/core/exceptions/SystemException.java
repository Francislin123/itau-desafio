package br.com.itau.desafioitau.core.exceptions;

public class SystemException extends InternalArchitectureException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
