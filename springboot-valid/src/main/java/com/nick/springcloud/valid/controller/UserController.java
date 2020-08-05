package com.nick.springcloud.valid.controller;

import com.nick.springcloud.valid.model.User;
import com.nick.springcloud.valid.valid.IsMobile;
import com.nick.springcloud.valid.validator.ValidationResultBO;
import com.nick.springcloud.valid.validator.ValidatorImpl;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author nick
 * @date 2020/6/26 8:50 PM
 * @package com.nick.springcloud.valid.controller
 * @description
 */
@RestController
@Validated
@Slf4j
public class UserController {

    @Autowired
    private ValidatorImpl validator;


    @GetMapping("/user")
    public ResponseEntity<Object> getUser(@NotBlank(message="手机号不能为空")
                                          @IsMobile(message="手机号格式不正确")
                                          @RequestParam String phone,
                                          @NotEmpty(message="用户名不能为空")
                                          @RequestParam String username,

                                          @Range(min = 1, max = 200, message = "年龄范围为1-200")
                                          @RequestParam Integer age) throws Exception {


        return ResponseEntity.ok().build();

    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestParam String phone,
                                          @RequestParam String username,
                                          @RequestParam Integer age) throws Exception{

        ValidationResultBO validate = validator.validate(User.builder()
                .phone(phone)
                .username(username)
                .age(age)
                .build());
        if (validate.isHasErrors()) {
            String errorMsg = validate.getErrorMsg();
            log.info("错误信息：{}",errorMsg);
            //这里需要自定义exception
//            throw new MyException(111,errorMsg);
        }

        return ResponseEntity.ok().build();
    }


}
