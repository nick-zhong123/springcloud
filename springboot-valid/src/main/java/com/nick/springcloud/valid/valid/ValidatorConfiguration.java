package com.nick.springcloud.valid.valid;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author nick
 * @date 2020/6/26 9:08 PM
 * @package com.nick.springcloud.valid.valid
 * @description
 */
@Configuration
public class ValidatorConfiguration {

    /**
     * failFast：true 快速失败返回模式 false 普通模式
     * @return
     */
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation
                .byProvider( HibernateValidator.class )
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    /**
     *
     * 和 （hibernate.validator.fail_fast：true 快速失败返回模式 false 普通模式）
     * @return
     */
//    @Bean
//    public Validator validator() {
//        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
//                .configure()
//                .addProperty("hibernate.validator.fail_fast", "true")
//                .buildValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//        return validator;
//    }



}
