package com.nick.springboot.starter.service;

/**
 * @author nick
 * @date 2020/6/28 9:10 AM
 * @package com.nick.springboot.starter.service
 * @description
 */
public class HelloService {

    private String msg;

    public String sayHello() {
        return "Hello," + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
