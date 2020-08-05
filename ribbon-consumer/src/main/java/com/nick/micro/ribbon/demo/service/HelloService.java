package com.nick.micro.ribbon.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author nick
 * @date 2020/5/10 5:33 PM
 * @package com.nick.micro.ribbon.demo.service
 * @description
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class HelloService {

    private static final String EUREKA_CLIENT = "http://eureka-client-hello-demo";

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService (String id) {
        String result = restTemplate.getForObject(EUREKA_CLIENT + "/hello?id=" + id, String.class);
        return result + ", ribbonDemo:" + id;
    }

    public String helloFallback (String id) {
        String msg =  "hystrix fallback, error, id:" + id;
        return msg;
    }

}
