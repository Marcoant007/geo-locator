package org.marcoantdev.app.exception;

public class ApiException extends RuntimeException {
    private int httpStatus;

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ApiException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
