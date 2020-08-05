package com.nick.springcloud.annotation.controller;

import com.nick.springcloud.annotation.annotation.EnableCostTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nick
 * @date 2020/6/19 11:04 PM
 * @package com.nick.springcloud.prometheus.controller
 * @description
 */
@Slf4j
@RestController
@RequestMapping("cost")
//@EnableCostTime
public class CostTimeController {

    @GetMapping("time")
    public String getClassCostTime() {
        log.info("@EnableCostTime from Class, getClassCostTime");
        return "CostTimeController hello";
    }

    @GetMapping("method")
    @EnableCostTime
    public String getMethodCostTime() {
        log.info("@EnableCostTime from Class, getMethodCostTime");
        return "CostTimeController method hello";
    }
}
