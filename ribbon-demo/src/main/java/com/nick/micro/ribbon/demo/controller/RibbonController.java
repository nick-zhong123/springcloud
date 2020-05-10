package com.nick.micro.ribbon.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author weizhong
 * @date 2020/5/8 5:54 PM
 * @package com.nick.micro.ribbon.demo.controller
 * @description
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ribbon")
public class RibbonController {

    private static final String EUREKA_CLIENT = "http://eureka-client-hello-demo";

    private final RestTemplate restTemplate;

    @GetMapping("/hello")
    public String getHello(String id) {
        String result = restTemplate.getForObject(EUREKA_CLIENT + "/hello?id=" + id, String.class);
        return result + ", ribbonDemo:" + id;
    }

}
