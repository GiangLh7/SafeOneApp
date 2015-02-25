package com.viettel.safe.one.configuration.annotation;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.annotation.*;

/**
 * Created by gianglh7 on 2/5/2015.
 */
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ControllerAdvice
public @interface RestEndpointAdvice
{
    String value() default "";
}
