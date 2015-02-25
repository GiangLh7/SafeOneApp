package com.viettel.safe.one.RestEndpoint;

import com.viettel.safe.one.configuration.annotation.RestEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gianglh7 on 2/5/2015.
 */
@RestEndpoint
@RequestMapping("/services/Rest/devices")
public class DeviceRestEndpoint {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }
}
