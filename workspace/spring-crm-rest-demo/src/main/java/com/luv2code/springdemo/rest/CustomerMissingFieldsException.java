package com.luv2code.springdemo.rest;

public class CustomerMissingFieldsException extends RuntimeException {

  public CustomerMissingFieldsException() {
  }

  public CustomerMissingFieldsException(String message) {
    super(message);
  }

  public CustomerMissingFieldsException(Throwable cause) {
    super(cause);
  }

  public CustomerMissingFieldsException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomerMissingFieldsException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
