package com.example.demo.controller;

import com.example.demo.annotation.TestAnnotation;
import com.example.demo.registerBeans.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.LinkedList;
import java.util.TreeSet;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Value("${author.name}")
    private String name;

    @Autowired
    Person allenBean;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @TestAnnotation
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
     *
     * @return
     */
    @RequestMapping(value = "/read-config", method = RequestMethod.GET)
    public String readConfig() {
        String authName = name;
        return authName;
    }

    @RequestMapping(value = "/get-bean", method = RequestMethod.GET)
    public String getBean() {
        return String.format("name:%s,age:%d,sex:%s", allenBean.getName(), allenBean.getAge(), allenBean.getSex());
    }

}
