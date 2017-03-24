package com.emc.esrs.logprocessor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas31 on 3/17/2017.
 */
public class Device implements Serializable{

    private String deviceName;

    private List<DeviceStatus> content = new ArrayList<DeviceStatus>();

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public List<DeviceStatus> getContent() {
        return content;
    }

    public void setContent(List<DeviceStatus> content) {
        this.content = content;
    }
}
