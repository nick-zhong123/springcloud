package com.nick.micro.nacos.client.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nick.micro.nacos.client.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @SentinelResource(value = "sayHello", fallback = "sayHelloFail")
    @Override
    public String sayHello() {
        log.info("sayHello suc");
        return "Say Hello" + LocalDateTime.now();
    }

    @Override
    public String sayHelloFail() {
        log.info("sayHello fail");
        return "Say Hello Fail" + LocalDateTime.now();
    }

}
