package com.nick.springcloud.valid.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author nick
 * @date 2020/6/26 8:54 PM
 * @package com.nick.springcloud.valid.validator
 * @description
 */
@Component
public class ValidatorImpl {

    @Autowired
    private Validator validator;


    /**
     * 实现校验方式并返回检验结果
     * @param value
     * @return
     */
    public ValidationResultBO validate(Object value){
        ValidationResultBO result = new ValidationResultBO();
        Set<ConstraintViolation<Object>> validateSet = validator.validate(value);
        if (!validateSet.isEmpty()) {
            result.setHasErrors(true);

            validateSet.forEach( (validation) -> {
                String errorMsg = validation.getMessage();
                String propertyName = validation.getPropertyPath().toString();
                result.getErrorMsgMap().put(propertyName, errorMsg);
            });
        }

        return result;
    }

}
