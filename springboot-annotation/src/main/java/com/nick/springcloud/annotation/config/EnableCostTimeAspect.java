package com.nick.springcloud.annotation.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author nick
 * @date 2020/6/19 11:08 PM
 * @package com.nick.springcloud.prometheus.config
 * @description
 */
@Component
@Aspect
@Slf4j
public class EnableCostTimeAspect {

    /**
     * AOP中扫描指定注解相关说明
     * （1）@annotation：用来拦截所有被某个注解修饰的方法
     * （2）@within：用来拦截所有被某个注解修饰的类
     * （3）within：用来指定扫描的包的范围
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@within(com.nick.springcloud.annotation.annotation.EnableCostTime)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object obj = pjp.proceed();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getSignature().getDeclaringTypeName();
        log.info("className:{}, methodName:{}, 方法耗时:{}ms", className, methodName, System.currentTimeMillis() - begin);
        return obj;
    }

}
