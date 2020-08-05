package com.nick.springcloud.valid.model;

import com.nick.springcloud.valid.valid.IsMobile;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author nick
 * @date 2020/6/26 8:57 PM
 * @package com.nick.springcloud.valid.model
 * @description
 */
@Data
@Builder
public class User {

    private Integer id;

    @NotBlank(message="手机号不能为空")
    @IsMobile
    private String phone;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @Range(min=1,max=200,message="年龄不能小于1大于200")
    private Integer age;


}
