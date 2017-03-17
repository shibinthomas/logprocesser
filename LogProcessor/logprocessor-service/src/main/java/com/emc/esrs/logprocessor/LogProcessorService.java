package com.emc.esrs.logprocessor;

import com.emc.esrs.rest.base.BaseService;
import com.emc.esrs.rest.util.VEUtil;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas31 on 3/17/2017.
 */
public class LogProcessorService extends BaseService<LogProcessorConfig> {

    Logger logger = LoggerFactory.getLogger(LogProcessorService.class);

    public static void main(String args[]) throws Exception {
        LogProcessorService logProcessorService = new LogProcessorService();
        if(args.length > 0){
            logProcessorService.run(args);
        }else{
            logProcessorService.run(new String[]{"service", "/opt/esrs/logprocessor/logprocessorConfig.yml"});
        }
    }

    @Override
    public void initialize(Bootstrap<LogProcessorConfig> bootstrap) {
        bootstrap.setName("LogProcessorService");
        bootstrap.addBundle(new AssetsBundle("/assets", "/esrs/logProcessorService"));
    }

    @Override
    public void run(LogProcessorConfig configuration,
                    Environment environment) {

        LogProcessorResource logProcessorResource = new LogProcessorResource(configuration.getDatabaseConfiguration());
        /**
         * Add resources to the list to read the class and method annotations*
         */
        List<Class> resourceClasses = new ArrayList<Class>();
        resourceClasses.add(logProcessorResource.getClass());

        VEUtil.getUnprotectedMethods(resourceClasses, configuration);
        super.run(configuration, environment);
        environment.addResource(logProcessorResource);
    }
}
