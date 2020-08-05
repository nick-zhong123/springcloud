package com.nick.springcloud.valid.model;

import com.nick.springcloud.valid.valid.IsMobile;
import com.nick.springcloud.valid.valid.ValidatorAdd;
import com.nick.springcloud.valid.valid.ValidatorEdit;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nick
 * @date 2020/6/26 8:42 PM
 * @package com.nick.springcloud.valid.model
 * @description
 */
@Data
public class LoginVo {

    /**
     * 编辑时：不能为null
     */
    @NotNull(message = "{login.id.NotNull}", groups = {ValidatorEdit.class})
    private String id;

    /**
     * 添加时：不能为空，符合邮箱格式
     * 编辑时：符合邮箱格式
     */
    @NotBlank(message = "{login.username.NotBlank}", groups = {ValidatorAdd.class})
    @Email(message = "{login.username.Email}", groups = {ValidatorAdd.class, ValidatorEdit.class})
    private String username;

    /**
     * 添加时：不能为空，密码长度至少为6位
     * 编辑时：密码长度至少为6位
     */
    @NotBlank(message = "{login.password.NotBlank}", groups = {ValidatorAdd.class})
    @Length(min = 6, message = "{login.password.Length}", groups = {ValidatorAdd.class, ValidatorEdit.class})
    private String password;

    /**
     * 添加时：符合手机格式
     * 编辑时：符合手机格式
     */
    @IsMobile(groups = {ValidatorAdd.class, ValidatorEdit.class})
    private String phone;

}
