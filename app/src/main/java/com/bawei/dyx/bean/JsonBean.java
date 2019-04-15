package com.bawei.dyx.bean;

import com.google.gson.JsonObject;

public class JsonBean {
    private String status;
     private String message;
     private JsonObject result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonObject getResult() {
        return result;
    }

    public void setResult(JsonObject result) {
        this.result = result;
    }
}
