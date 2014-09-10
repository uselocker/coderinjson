package me.uselocker.coderinjson.exception;

public class CyclicLinkException extends Exception {
    public CyclicLinkException() {
    }

    public CyclicLinkException(String message) {
        super(message);
    }

    public CyclicLinkException(String message, Throwable cause) {
        super(message, cause);
    }

    public CyclicLinkException(Throwable cause) {
        super(cause);
    }

    public CyclicLinkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
