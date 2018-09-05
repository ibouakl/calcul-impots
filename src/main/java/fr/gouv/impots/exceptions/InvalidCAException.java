package fr.gouv.impots.exceptions;

public class InvalidCAException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCAException() {
        super();
    }

    public InvalidCAException(String message) {
        super(message);
    }

    public InvalidCAException(Throwable cause) {
        super(cause);
    }

    public InvalidCAException(String message, Throwable cause) {
        super(message, cause);
    }
}