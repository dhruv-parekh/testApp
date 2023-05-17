package com.example.testApp.exception;

public class RestrictedInfoException extends Exception{

    @Override
    public String getMessage() {
        return "Restricted Access.";
    }
}
