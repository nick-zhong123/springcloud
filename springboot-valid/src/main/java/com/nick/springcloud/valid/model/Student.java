package com.nick.springcloud.valid.model;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author nick
 * @date 2020/6/26 6:19 PM
 * @package com.nick.springcloud.valid.model
 * @description
 */
@Data
public class Student {

    private Integer id;

    @NotEmpty(message="姓名不能为空！")//验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0）
    private String name;

    @NotNull(message="年龄不能为空！")//限制必须不为null
    @Min(value=18,message="年龄必须大于18岁！")//限制必须为一个不小于指定值的数字
    private Integer age;

}
