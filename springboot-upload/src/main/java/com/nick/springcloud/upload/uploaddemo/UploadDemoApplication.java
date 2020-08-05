package com.nick.springcloud.upload.uploaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "com.nick.springcloud.upload.uploaddemo")
public class UploadDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadDemoApplication.class, args);
    }

}
