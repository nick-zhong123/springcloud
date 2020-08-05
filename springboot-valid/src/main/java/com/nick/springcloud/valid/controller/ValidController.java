package com.nick.springcloud.valid.controller;

import com.nick.springcloud.valid.exception.RRException;
import com.nick.springcloud.valid.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author nick
 * @date 2020/6/25 9:10 PM
 * @package com.nick.springcloud.valid.controller
 * @description
 */
@Slf4j
@RestController
@RequestMapping("valid")
public class ValidController {

    @GetMapping
    public String valid() {
        return "OK";
    }

    @GetMapping("myInfo")
    public String myInfo(@RequestParam Integer id) {
        log.info("myInfo, id:{}", id);
        if (id == null) {
            throw new RRException("id不能为空！");
        }
        return "OK";
    }

    /**
     *
     * 添加图书
     *
     * @param student
     * @param bindingResult
     * @return
     */
    @PostMapping("/addStudent")
    public String add(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
         return "添加成功";
    }

}
