package com.nick.springcloud.upload.uploaddemo.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author weizhong
 * @date 2020/6/16 10:33 PM
 * @package com.nick.springcloud.upload.uploaddemo.property
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
public class FileProperties {

    private String uploadDir;

}
