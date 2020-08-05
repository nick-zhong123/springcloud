package com.nick.springcloud.valid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nick.springcloud.valid.exception.RRException;
import com.nick.springcloud.valid.model.ResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 * @date 2020/6/26 6:43 PM
 * @package com.nick.springcloud.valid.controller
 * @description
 *  @ControllerAdvice
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.info("binder.getFieldDefaultPrefix {}",binder.getFieldDefaultPrefix());
        log.info("binder.getFieldMarkerPrefix {}",binder.getFieldMarkerPrefix());
    }

    /**
     *
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "harry");
    }

    /**
     * Description : 全局异常捕捉处理
     * Group :
     *
     * @author honghh
     * @date  2019/4/1 0001 10:34
     * @param ex
     * @return
     *
     */
    @ExceptionHandler(RRException.class)
    public ResDto apiExceptionHandler(RRException ex) {
        log.error("ApiException 异常抛出：{}", ex);
        return ResDto.fail(ex);
    }

    /**
     *
     * 该方法前端有返回错误，但是一直无法获取到BindException 异常。
     * @param exception
     * @return
     * @throws JsonProcessingException
     *
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String exception(MethodArgumentNotValidException exception) throws JsonProcessingException {
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        List<String> errorMsg = new ArrayList<>();

        for (FieldError error : fieldErrors) {
            errorMsg.add(error.getDefaultMessage());
        }
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(errorMsg);
    }

    @ExceptionHandler(BindException.class)
    public String handle(BindException ex) {
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : ex.getFieldErrors()) {
            sb.append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage())
                    .append(";");
        }
        return "验证失败：" + sb.toString();
    }

}
