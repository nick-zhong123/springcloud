package com.nick.micro.nacos.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 *
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientDemoApplication.class, args);
    }

}
