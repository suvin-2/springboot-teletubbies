package com.project.teletubbies.exception;

public class APIException extends Exception {

    private static final long serialVersionUID = 3254595443149980209L;

    private int errorCode;

    private String errorMessage;

    public APIException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public APIException(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
