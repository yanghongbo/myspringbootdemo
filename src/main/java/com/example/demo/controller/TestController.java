package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Value("${author.name}")
    private String  name;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log() {
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");

        return "ok";
    }

    /**
     * 读取配置文件中的属性
     * @return
     */
    @RequestMapping(value = "/read-config", method = RequestMethod.GET)
    public String readConfig() {
        String authName = name;
        return authName;
    }
}
