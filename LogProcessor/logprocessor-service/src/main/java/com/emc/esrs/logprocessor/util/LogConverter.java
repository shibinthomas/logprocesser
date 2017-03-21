package com.emc.esrs.logprocessor.util;

import com.emc.esrs.logprocessor.model.Device;
import com.emc.esrs.logprocessor.model.DeviceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by thomas31 on 3/20/2017.
 */
public class LogConverter implements ILogConverter{

    private Logger logger = LoggerFactory.getLogger(LogConverter.class);

    private static final String LOG_LOC = "/opt/esrsve/esrslogprocessor/count.sh";

    public  Device process(){

        logger.info("START : process");

        Device devices = new Device();
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(LOG_LOC);
            proc.waitFor();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            Map<String, String> map = new LinkedHashMap<String, String>();
            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line);
            }

            StringTokenizer st = new StringTokenizer(output.toString() , ",");
            devices.setDeviceName(st.nextToken());
            while(st.hasMoreTokens())
            {
                DeviceStatus status = new DeviceStatus();
                String token = st.nextToken();
                status.setStatusCode(token.split(":")[0]);
                status.setCount(Integer.parseInt(token.split(":")[1]));
                devices.getStatusList().add(status);
            }

        } catch (Exception t) {
            t.printStackTrace();
        }
        logger.info("END : process");
        return devices;
    }
}
