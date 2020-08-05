package com.nick.springcloud.portal.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nick.springcloud.portal.platform.mapper")
@SpringBootApplication(scanBasePackages={"com.nick.springcloud"})
public class PlatformServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformServiceApplication.class, args);
    }

}
