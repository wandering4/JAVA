package com.config;

import com.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 Spring的配置类
 作用是替换配置文件
 */
@Configuration //加了这个注解，我们的这个配置类就相当于applicationContext.xml 配置文件
@ComponentScan(basePackages = "com") //扫描的包
public class SpringConfiguration {

    /**
     * 我们可以在相关方法头部添加@Bean注解 可以实现将该方法返回对象注入容器
     * @return
     */
    @Bean
    public User user(){
        return new User(1,"boge1");
    }
}
