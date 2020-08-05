package com.nick.springcloud.valid.validator;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nick
 * @date 2020/6/26 8:53 PM
 * @package com.nick.springcloud.valid.validator
 * @description
 */
@Data
public class ValidationResultBO {

    private boolean hasErrors = false;

    private Map<String,String> errorMsgMap = new HashMap<String, String>();

    //返回错误信息
    public String getErrorMsg(){
        return StringUtils.join(errorMsgMap.values().toArray(),",");
    }


}
