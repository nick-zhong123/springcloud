package com.nick.springboot.starteruse.service;

import com.nick.springboot.starter.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author nick
 * @date 2020/6/28 9:27 AM
 * @package com.nick.springboot.starteruse.service
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class InfoService {

    private final HelloService helloService;

    public void Hello() {
        String msg = helloService.sayHello();
        log.info("msg:{}", msg);
    }

}
