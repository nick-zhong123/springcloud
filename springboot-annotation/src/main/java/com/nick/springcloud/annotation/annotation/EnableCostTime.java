package com.nick.springcloud.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author nick
 * @date 2020/6/19 11:07 PM
 * @package com.nick.springcloud.prometheus.annotation
 * @description
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCostTime {

    String value() default "";

}
