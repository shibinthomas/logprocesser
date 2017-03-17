package com.emc.esrs.logprocessor.model;

import java.io.Serializable;

/**
 * Created by thomas31 on 3/17/2017.
 */
public class DeviceStatus implements Serializable{

    private String statusCode;
    private int count;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
