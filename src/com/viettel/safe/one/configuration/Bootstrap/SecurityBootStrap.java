package com.viettel.safe.one.configuration.Bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by gianglh7 on 2/4/2015.
 */
@SuppressWarnings("unused")
@Order(2)
public class SecurityBootStrap extends AbstractSecurityWebApplicationInitializer {
    //private static final Logger log = LogManager.getLogger();

    @Override
    protected boolean enableHttpSessionEventPublisher()
    {
        //log.info("Executing security bootstrap.");

        return true;
    }
}
