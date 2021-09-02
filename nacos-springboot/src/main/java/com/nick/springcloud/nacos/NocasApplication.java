package com.nick.springcloud.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@NacosPropertySource(dataId = "nacos-client-demo1", autoRefreshed = true)
@SpringBootApplication
public class NocasApplication {

    public static void main(String[] args) {
        SpringApplication.run(NocasApplication.class, args);
    }

}
