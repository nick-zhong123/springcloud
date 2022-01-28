package com.nick.micro.nacos.client.controller;

import com.nick.micro.nacos.client.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author nick
 * @date 2020/5/8 2:50 PM
 * @package com.nick.micro.eureka.client.controller
 * @description
 *
 */
@Slf4j
@RequestMapping("hello")
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("say")
    public String sayHello(String id) {
//        log.info("sayHello, id:{}", id);
        return helloService.sayHello();
    }

    @GetMapping("id")
    public String returnId(String id) {
        log.info("returnId, id:{}", id);
        return "hello: " + id;
    }

}
