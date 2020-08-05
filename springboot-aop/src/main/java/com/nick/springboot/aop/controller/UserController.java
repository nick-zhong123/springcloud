package com.nick.springboot.aop.controller;

import com.nick.springboot.aop.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

/**
 * @author nick
 * @date 2020/6/14 1:59 PM
 * @package com.nick.springboot.aop.controller
 * @description
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public User getUser(String id, String name) {
        log.info("getUser, id:{}, name:{}", id, name);
        return User.builder()
                .id(101)
                .userName("aop boy")
                .build();
    }

    @PostMapping("add")
    public boolean addUser(@RequestBody User user) {
        log.info("Add User:{}", user);
        return true;
    }

}
