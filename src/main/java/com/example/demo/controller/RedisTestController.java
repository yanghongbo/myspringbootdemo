package com.example.demo.controller;

import com.example.demo.core.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisTestController {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/set/{key}/{val}", method = RequestMethod.GET)
    public String set(@PathVariable("key") String key, @PathVariable("val") String val) {
        redisUtil.set(key, val);
        return "ok";
    }

    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    public String get(@PathVariable("key") String key) {
        return redisUtil.get(key);
    }
}
