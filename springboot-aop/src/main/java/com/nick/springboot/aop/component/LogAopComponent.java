package com.nick.springboot.aop.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author nick
 * @date 2020/6/14 1:57 PM
 * @package com.nick.springboot.aop.component
 * @description
 */
@Slf4j
@Aspect
@Component
public class LogAopComponent {

    @Before(value = "com.nick.springboot.aop.component.PointCut.logPoint()")
    public void before(JoinPoint joinPoint) {
        log.info("[Aspect1] before advise");
    }

    @Around(value = "com.nick.springboot.aop.component.PointCut.logPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws  Throwable{
        long s1 = System.currentTimeMillis();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object object = joinPoint.proceed();
        long s2 = System.currentTimeMillis();
        String className = joinPoint.getSignature().toString();
        String requestUrl = request.getRequestURL().toString();
        String requestToken = request.getHeader("token");
        String httpMethod = request.getMethod();
        String requestParas = Arrays.toString(joinPoint.getArgs());
        String costTime = (s2 - s1) + "";

        log.info("\nclassName:{},\n requestUrl:{},\n requestToken:{},\n httpMethod:{},\n requestParas:{},\n costTime:{}",
                className, requestUrl, requestToken, httpMethod, requestParas, costTime);
        return object;
    }

    @AfterReturning(value = "com.nick.springboot.aop.component.PointCut.logPoint()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("[Aspect1] AfterReturning advise");
    }

    @AfterThrowing(value = "com.nick.springboot.aop.component.PointCut.logPoint()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("[Aspect1] AfterThrowing advise");
    }

    @After(value = "com.nick.springboot.aop.component.PointCut.logPoint()")
    public void after(JoinPoint joinPoint) {
        log.info("[Aspect1] After advise");
    }

}
