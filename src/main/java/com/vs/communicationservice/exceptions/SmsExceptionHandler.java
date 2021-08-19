package com.vs.communicationservice.exceptions;

public class SmsExceptionHandler extends Exception{
    private String text;

    public SmsExceptionHandler(SmsException exception) {
        this.text = exception.toString();
    }
}
