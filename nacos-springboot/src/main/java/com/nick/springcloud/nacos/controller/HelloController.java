package com.nick.springcloud.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nick
 * @date 2020/6/20 9:59 AM
 * @package com.nick.springcloud.prometheus.controller
 * @description
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/info")
    public String getInfo() {
        return "Good News";
    }

}
