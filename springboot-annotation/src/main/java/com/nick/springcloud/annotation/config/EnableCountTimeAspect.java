package com.nick.springcloud.annotation.config;

import com.nick.springcloud.annotation.annotation.EnableCountTime;
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
public class EnableCountTimeAspect {

    @Around("@annotation(ect) || @within(ect)")
    public Object doAround(ProceedingJoinPoint pjp, EnableCountTime ect) throws Throwable {
        long begin = System.currentTimeMillis();
        Object obj = pjp.proceed();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getSignature().getDeclaringTypeName();
        log.info("className:{}, methodName:{}, 方法耗时:{}ms", className, methodName, System.currentTimeMillis() - begin);
        return obj;
    }

}
