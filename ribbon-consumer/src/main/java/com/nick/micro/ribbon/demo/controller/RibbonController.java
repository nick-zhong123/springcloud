package com.nick.micro.ribbon.demo.controller;

import com.nick.micro.ribbon.demo.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nick
 * @date 2020/5/8 5:54 PM
 * @package com.nick.micro.ribbon.demo.controller
 * @description
 *
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ribbon")
public class RibbonController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String getHello(String id) {
        return helloService.helloService(id);
    }

}
