package com.viettel.safe.one.configuration.Bootstrap;

import com.viettel.safe.one.configuration.Filter.PreSecurityLoggingFilter;
import com.viettel.safe.one.configuration.RestContextConfiguration;
import com.viettel.safe.one.configuration.RootContextConfiguration;
import com.viettel.safe.one.configuration.WebContextConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by gianglh7 on 2/4/2015.
 */

@SuppressWarnings("unused")
@Order(1)
public class FrameworkBootStrap implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class);
        container.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebContextConfiguration.class);

        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "springWebDispatcher", new DispatcherServlet(webContext)
        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.setMultipartConfig(new MultipartConfigElement(null, 20_971_520L, 41_943_040L, 512_000));
        dispatcher.addMapping("/");

        AnnotationConfigWebApplicationContext restContext =  new AnnotationConfigWebApplicationContext();
        restContext.register(RestContextConfiguration.class);
        DispatcherServlet restServlet = new DispatcherServlet(restContext);
        restServlet.setDispatchOptionsRequest(true);
        dispatcher = container.addServlet("springRestDispatcher", restServlet);
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/services/Rest/*");

        FilterRegistration.Dynamic registration = container.addFilter("preSecurityLoggingFilter", new PreSecurityLoggingFilter());
        registration.addMappingForUrlPatterns(null, false, "/*");
    }
}
