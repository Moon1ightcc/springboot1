package com.boot.config;

import com.boot.bean.Car;
import com.boot.bean.Pet;
import com.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、配置类中使用@Bean标注再方法上给容器注册组件,默认也是单例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods : 代理bean的方法
 *      Full(proxyBeanMethods = true)（保证每个@Bean方法被调用多少次返回的组件都是单实例的）（默认）
 *      Lite(proxyBeanMethods = false)（每个@Bean方法被调用多少次返回的组件都是新创建的）
 *      组件依赖
 */
@ImportResource("classpath:beans.xml")
@Configuration(proxyBeanMethods = false) // 告诉SpringBoot这是一个配置类 == 配置文件
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     */
    @Bean //给容器中添加组件,以方法名作为组件的id,返回类型就是组件类型。返回的值,就是组件再容器中的实例
    public User user01(){
        User michel = new User("Michel", 10);
        michel.setPet(tomcatPet());
        return michel;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
