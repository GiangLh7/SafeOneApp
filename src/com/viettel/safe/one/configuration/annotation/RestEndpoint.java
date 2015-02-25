package com.viettel.safe.one.configuration.annotation;

import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

/**
 * Created by gianglh7 on 2/5/2015.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
public @interface RestEndpoint {
    String value() default "";
}
