package ru.veers.app.exception;

public class DifferentPasswordException extends RuntimeException {
    public DifferentPasswordException(String s) {
        super(s);
    }
}
