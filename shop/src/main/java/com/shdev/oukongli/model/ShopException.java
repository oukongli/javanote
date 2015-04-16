package com.shdev.oukongli.model;

/**
 * Created by ou_kongli on 2015/4/16.
 */
public class ShopException extends RuntimeException{
    public ShopException() {
        super();
    }

    public ShopException(String message) {
        super(message);
    }

    public ShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopException(Throwable cause) {
        super(cause);
    }

    protected ShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
