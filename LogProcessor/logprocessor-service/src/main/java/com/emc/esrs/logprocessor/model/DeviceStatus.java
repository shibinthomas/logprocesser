package com.emc.esrs.logprocessor.model;

import java.io.Serializable;

/**
 * Created by thomas31 on 3/17/2017.
 */
public class DeviceStatus implements Serializable{

    private String label;
    private int value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
