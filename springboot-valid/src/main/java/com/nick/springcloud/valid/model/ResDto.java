package com.nick.springcloud.valid.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nick
 * @date 2020/6/26 6:45 PM
 * @package com.nick.springcloud.valid.model
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResDto {

    private Integer code;
    private String msg;
    private Boolean success;
    private String message;

    public static ResDto fail(Exception e) {
        return ResDto.builder()
                .code(500)
                .msg("fail")
                .success(false)
                .message(e.getMessage())
                .build();
    }

}
