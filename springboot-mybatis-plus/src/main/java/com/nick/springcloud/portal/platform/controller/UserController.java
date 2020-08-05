package com.nick.springcloud.portal.platform.controller;

import com.nick.springcloud.portal.platform.mapper.UserMapper;
import com.nick.springcloud.portal.platform.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nick
 * @date 2020/5/31 11:22 AM
 * @package com.nick.springcloud.portal.platform.controller
 *
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(value="用户管理")
public class UserController {

    private final UserMapper userMapper;

    @GetMapping("/info")
    @ApiOperation("获取用户信息")
    public List<User> getUserInfo() {
        List<User> userList = userMapper.selectList(null);
        return userList;
//        return User.builder().id("1").name("小明").nickName("布布").age(12)
//                .build();
    }

}
