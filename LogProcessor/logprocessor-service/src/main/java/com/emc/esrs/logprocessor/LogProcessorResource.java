package com.emc.esrs.logprocessor;

import com.emc.esrs.logprocessor.model.Device;
import com.emc.esrs.logprocessor.model.DeviceStatus;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by thomas31 on 3/17/2017.
 */
@Path("/esrs/logProcessor")
@Produces(MediaType.APPLICATION_JSON)
public class LogProcessorResource{

    Logger logger = LoggerFactory.getLogger(LogProcessorResource.class);

    private DatabaseConfiguration config;

    public LogProcessorResource(DatabaseConfiguration databaseConfiguration){
        this.config = databaseConfiguration;
    }

    @GET
    public Device sample(){
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setCount(2);
        deviceStatus.setStatusCode("404");
        Device device = new Device();
        device.setDeviceName("ABCD");
        device.getStatusList().add(deviceStatus);
        return device;
    }
}
