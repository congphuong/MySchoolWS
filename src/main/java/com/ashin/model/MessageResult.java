package com.ashin.model;

/**
 * Created by Khuong on 2017-06-05.
 */
public class MessageResult {
    private boolean success;
    private String message;

    public MessageResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
