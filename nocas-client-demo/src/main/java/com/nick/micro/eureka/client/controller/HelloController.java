package com.nick.micro.eureka.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nick
 * @date 2020/5/8 2:50 PM
 * @package com.nick.micro.eureka.client.controller
 * @description
 *
 *
 */
@Slf4j
@RequestMapping("hello")
@RestController
public class HelloController {

    @GetMapping
    public String hello(String id) {
        return "hello: " + id;
    }

}
