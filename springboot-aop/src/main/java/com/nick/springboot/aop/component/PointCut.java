package com.nick.springboot.aop.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author nick
 * @date 2020/6/14 2:08 PM
 * @package com.nick.springboot.aop.component
 * @description
 */
@Slf4j
public class PointCut {

    @Pointcut(value = "execution(public * com.nick.springboot.aop.controller.*.*(..))")
    public void logPoint() {}

}
