package com.nick.springboot.aop.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author nick
 * @date 2020/6/14 2:01 PM
 * @package com.nick.springboot.aop.model
 * @description
 */
@Data
@Builder
public class User {

    private Integer id;

    private String userName;

}
