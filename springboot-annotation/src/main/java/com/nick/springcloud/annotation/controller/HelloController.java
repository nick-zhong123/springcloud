package com.nick.springcloud.annotation.controller;

import com.nick.springcloud.annotation.annotation.EnableCountTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nick
 * @date 2020/6/19 11:04 PM
 * @package com.nick.springcloud.prometheus.controller
 * @description
 */
@Slf4j
@RestController
@RequestMapping("hello")
@EnableCountTime
public class HelloController {

    @GetMapping
    public String getInfo() {
        return "com.nick.springcloud.annotation.controller hello";
    }

}
