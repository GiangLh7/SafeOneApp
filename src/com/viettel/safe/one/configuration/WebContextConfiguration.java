package com.viettel.safe.one.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by gianglh7 on 2/5/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = "com.viettel.safe.one",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(Controller.class)
)
public class WebContextConfiguration extends WebMvcConfigurerAdapter {
}
