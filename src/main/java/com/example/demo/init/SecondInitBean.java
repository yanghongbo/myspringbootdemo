package com.example.demo.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 2)
@Component
public class SecondInitBean implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void run(String... args) {
        logger.info("第二个初始化动作");
    }
}
