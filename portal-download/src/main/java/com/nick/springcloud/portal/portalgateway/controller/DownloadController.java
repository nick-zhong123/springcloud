package com.nick.springcloud.portal.portalgateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nick
 * @date 2020/5/14 4:00 PM
 * @package com.nick.springcloud.portal.portalgateway.controller
 * @description
 *  提供
 */
@Slf4j
@Controller
public class DownloadController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/download")
    public String test(){
        return "download";
    }

}
