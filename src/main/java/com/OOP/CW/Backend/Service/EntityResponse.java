package com.OOP.CW.Backend.Service;

public class EntityResponse {
    private Object object;
    private String message;

    public EntityResponse(Object object, String message) {
        this.object = object;
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
