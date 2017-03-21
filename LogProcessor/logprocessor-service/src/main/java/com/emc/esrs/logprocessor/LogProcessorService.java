package com.emc.esrs.logprocessor;

import com.emc.esrs.logprocessor.util.LogConverter;
import com.emc.esrs.rest.base.BaseService;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by thomas31 on 3/17/2017.
 */
public class LogProcessorService extends BaseService<LogProcessorConfig> {

    Logger logger = LoggerFactory.getLogger(LogProcessorService.class);

    public static void main(String args[]) throws Exception {
        new LogProcessorService().run(args);
    }

    @Override
    public void initialize(Bootstrap<LogProcessorConfig> bootstrap) {
        bootstrap.setName("LogProcessorService");
        bootstrap.addBundle(new AssetsBundle("/assets", "/esrs/logProcessorService"));
    }

    public void run(final LogProcessorConfig configuration, Environment environment) {
        super.run(configuration, environment);

        environment.addResource(new LogProcessorResource(new LogConverter()));
    }
}
