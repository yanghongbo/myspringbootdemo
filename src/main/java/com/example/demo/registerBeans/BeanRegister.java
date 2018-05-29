package com.example.demo.registerBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration相当于xml配置中的beans标签，@Bean相当于xml配置中的bean标签
 * 两者结合使用用于向spring boot的IOC容器中注册bean,这里会通过单例的方式注册一个Person类型的实例对象
 * 使用该实例的时候可以通过@Autowried结合Person类型来注入注册的服务
 */
@Configuration
public class BeanRegister {

    @Bean
    public Person getPerson() {
        Person allen = new Person();
        allen.setAge(28);
        allen.setSex("man");
        allen.setName("allen.yang");
        return allen;
    }
}
