package com.viettel.safe.one.configuration.Bootstrap;

import com.viettel.safe.one.configuration.Filter.PostSecurityLoggingFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by gianglh7 on 2/5/2015.
 */

@SuppressWarnings("unused")
@Order(3)
public class LoggingBootStrap implements WebApplicationInitializer
{
    //private static final Logger log = LogManager.getLogger();

    @Override
    public void onStartup(ServletContext container) throws ServletException
    {
        //log.info("Executing logging bootstrap.");

        FilterRegistration.Dynamic registration = container.addFilter(
                "postSecurityLoggingFilter", new PostSecurityLoggingFilter()
        );
        registration.addMappingForUrlPatterns(null, false, "/*");
    }
}