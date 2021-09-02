package com.nick.springcloud.nacos.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nick
 * @date 6/6/21 3:57 PM
 * @package com.nick.springcloud.prometheus.controller
 * @description
 */
@RestController
@RequestMapping("nacos-config")
public class NacosController {

    @NacosInjected
    private ConfigService configService;

    // curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example&group=DEFAULT_GROUP&content=useLocalCache=true"
    // curl -X POST "http://172.16.5.2:8848/nacos/v1/cs/configs?dataId=nacos-client-demo1&group=DEFAULT_GROUP&content=useLocalCache=true"
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping(value = "/get")
    public boolean get() {
        return useLocalCache;
    }

    @GetMapping(value = "/getInstance")
    @ResponseBody
    public String getInstance(@RequestParam String serviceName) throws NacosException {
        return configService.getServerStatus();
    }

}
