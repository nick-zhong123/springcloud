package com.nick.springcloud.valid.controller;

import com.nick.springcloud.valid.model.LoginVo;
import com.nick.springcloud.valid.valid.ValidatorAdd;
import com.nick.springcloud.valid.valid.ValidatorEdit;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author nick
 * @date 2020/6/26 8:43 PM
 * @package com.nick.springcloud.valid.controller
 * @description
 */
@RestController
public class ValidatorController {


    /**
     * 持久化
     */
    private static final HashMap<String, LoginVo> map = new HashMap<>();

    /**
     * 添加时
     *
     * @param loginVo
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(@Validated({ValidatorAdd.class}) LoginVo loginVo) {
        loginVo.setId(UUID.randomUUID().toString().replace("-", ""));
        map.put(loginVo.getId(), loginVo);
        return "添加通过：" + loginVo.toString();
    }

    /**
     * 编辑时
     *
     * @param loginVo
     * @return
     */
    @RequestMapping(value = "/edit")
    public String edit(@Validated({ValidatorEdit.class}) LoginVo loginVo) {
        map.replace(loginVo.getId(), map.get(loginVo.getId()), loginVo);
        return "编辑通过：" + loginVo.toString();
    }

    /**
     * 列表
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public Map<String, LoginVo> edit() {
        return map;
    }


}
