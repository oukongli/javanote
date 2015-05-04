package com.oukongli.model;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public class ShopException extends RuntimeException {
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
}
