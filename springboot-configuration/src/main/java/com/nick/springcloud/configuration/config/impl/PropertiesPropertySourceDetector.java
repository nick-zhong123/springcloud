package com.nick.springcloud.configuration.config.impl;

import com.nick.springcloud.configuration.config.AbstractPropertySourceDetector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author nick
 * @date 2020/6/10 9:44 PM
 * @package com.nick.springcloud.configuration.config
 * @description
 */
@Slf4j
public class PropertiesPropertySourceDetector extends AbstractPropertySourceDetector {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "conf"};
    }

    @SuppressWarnings("unchecked")
    @Override
    public void load(ConfigurableEnvironment environment, String name, Resource resource) throws IOException {
        Map map = PropertiesLoaderUtils.loadProperties(resource);
        addPropertySource(environment, new MapPropertySource(name, map));
    }

}
