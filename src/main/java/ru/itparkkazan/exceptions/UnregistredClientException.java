package ru.itparkkazan.exceptions;

public class UnregistredClientException extends Exception {
    public UnregistredClientException() {
        super();
    }

    public UnregistredClientException(String message) {
        super(message);
    }
}
