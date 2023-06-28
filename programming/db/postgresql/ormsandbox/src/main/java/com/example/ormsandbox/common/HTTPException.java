package com.example.ormsandbox.common;

public class HTTPException extends Exception{

    private int httpCode;


    public HTTPException(int httpCode, String message) {
        super(message);
        this.httpCode = httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

}
