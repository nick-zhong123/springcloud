package com.nick.springcloud.cache.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author nick
 * @date 2020/6/25 9:54 AM
 * @package com.nick.springcloud.cache.model
 * @description
 */
@Data
@ToString
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 8441706661454894556L;

    private Integer id;
    private String name;
    private String sex;
    private Integer age;

}
