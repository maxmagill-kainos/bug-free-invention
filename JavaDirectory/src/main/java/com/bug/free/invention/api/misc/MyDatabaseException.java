package com.bug.free.invention.api.misc;

public class MyDatabaseException extends Exception {
    public MyDatabaseException(String message) {
        super(message);
    }

    public MyDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
