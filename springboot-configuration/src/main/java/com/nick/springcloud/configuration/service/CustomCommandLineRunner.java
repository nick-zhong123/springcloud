package com.nick.springcloud.configuration.service;

import com.nick.springcloud.configuration.config.PropertySourceDetectorConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * @author nick
 * @date 2020/6/10 9:55 PM
 * @package com.nick.springcloud.configuration.service
 * @description
 */
@Slf4j
@Component
@Import(PropertySourceDetectorConfiguration.class)
public class CustomCommandLineRunner implements CommandLineRunner {
//public class CustomCommandLineRunner  {

//    @Value("${app.name}")
//    String name;

//    @Value("${app.age}")
//    Integer age;

    @Value("${spring.redis.db}")
    Integer db;
//
//    @Autowired
//    ConfigurableEnvironment configurableEnvironment;

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("CustomCommandLineRunner CommandLineRunner-----------");
//    }

    @Override
    public void run(String... args) throws Exception {
//        log.info("name = {},age = {}, db:{}", name, age, db);
        log.info("db:{}", db);
    }

}
