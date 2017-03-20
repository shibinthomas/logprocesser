package com.emc.esrs.logprocessor;

import com.emc.esrs.logprocessor.model.Device;
import com.emc.esrs.logprocessor.model.DeviceStatus;
import com.emc.esrs.logprocessor.util.LogConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by thomas31 on 3/17/2017.
 */
@Path("/esrs/v1/logprocessor/")
@Produces(MediaType.APPLICATION_JSON)
public class LogProcessorResource{

    Logger logger = LoggerFactory.getLogger(LogProcessorResource.class);

    public LogProcessorResource(){}

    @GET
    @Path("readlogdata")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readLogData(){

        return Response.ok(new LogConverter().process()).build();
    }
}
