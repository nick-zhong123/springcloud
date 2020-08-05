package com.nick.springboot.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author nick
 * @date 2020/6/28 9:08 AM
 * @package com.nick.springboot.starter.config
 * @description
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
