package com.scaler.BookMyShow.exception;

public class ShowSeatNotAvailable extends Exception{

    public ShowSeatNotAvailable(String message) {
        super(message);
    }

    public ShowSeatNotAvailable(String message, Throwable cause) {
        super(message, cause);
    }

    public ShowSeatNotAvailable(Throwable cause) {
        super(cause);
    }

    public ShowSeatNotAvailable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

/*
Alt + Insert = inside the class body to add all the constructors
 */
