package com.example.demo.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 通过注册一个实现了CommandLineRunner的bean可以执行在应用启动时执行的动作，该类中只需要实现run方法，
 * run中可以放置需要在应用启动时执行的动作
 * 如果注册了多个bean，可以通过@Order注解控制它们的执行顺序，值越小的越先执行
 *
 */
@Order(value = 1)
@Component
public class FirstInitBean implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public void run(String... args) {
        logger.info("第一个初始化动作");
    }
}
