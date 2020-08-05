package com.nick.springcloud.configuration.config;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author nick
 * @date 2020/6/7 5:10 PM
 * @package com.nick.springcloud.configuration.config
 * @description
 */
public interface PropertySourceDetector {

    /**
     * 获取支持的文件后缀数组
     *
     * @return String[]
     */
    String[] getFileExtensions();

    /**
     * 加载目标文件属性到环境中
     *
     * @param environment environment
     * @param name name
     * @param resource resource
     * @throws IOException IOException
     */
    void load(ConfigurableEnvironment environment, String name, Resource resource) throws IOException;

}
