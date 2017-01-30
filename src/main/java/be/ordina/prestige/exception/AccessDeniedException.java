package be.ordina.prestige.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class AccessDeniedException extends RuntimeException {

    private String message;
    private Throwable cause;

    public AccessDeniedException(String message) {
        super(message);
        this.message = message;
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }
}
