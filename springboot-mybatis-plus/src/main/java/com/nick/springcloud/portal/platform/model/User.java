package com.nick.springcloud.portal.platform.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nick
 * @date 2020/6/1 9:52 PM
 * @package com.nick.springcloud.portal.platform.model
 * @description
 */
@ApiModel("用户信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    @TableId
    @ApiModelProperty("id")
    private String id;

    @TableField
    @ApiModelProperty("名称")
    private String name;

    @TableField
    @ApiModelProperty("年龄")
    private Integer age;

    @TableField
    @ApiModelProperty("昵称")
    private String nickName;

}
