package com.nick.springcloud.configuration.config.impl;

import com.nick.springcloud.configuration.config.AbstractPropertySourceDetector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.YamlJsonParser;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;

/**
 * @author nick
 * @date 2020/6/10 9:44 PM
 * @package com.nick.springcloud.configuration.config
 * @description
 */
@Slf4j
public class YamlPropertySourceDetector extends AbstractPropertySourceDetector {

    private static final JsonParser YAML_PARSER = new YamlJsonParser();
    private static final  Yaml yaml = new Yaml();

    @Override
    public String[] getFileExtensions() {
        return new String[]{"yaml", "yml"};
    }

    @Override
    public void load(ConfigurableEnvironment environment, String name, Resource resource) throws IOException {
        try {
            String contentString = getContentStringFromResource(resource);
//            Map<String, Object> map = YAML_PARSER.parseMap(contentString);
            Map<String, Object> map = yaml.load(contentString);
            Map<String, Object> target = flatten(map);
            addPropertySource(environment, new MapPropertySource(name, target));
        } catch (Exception e) {
            log.warn("加载Yaml文件属性到环境变量失败,name = {},resource = {}", name, resource);
        }
    }

}
