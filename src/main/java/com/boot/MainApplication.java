package com.boot;

import com.boot.bean.Pet;
import com.boot.bean.User;
import com.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*
 *主程序类
 *@SpringBootApplication 这是一个springboot应用
 * scanBasePackages是一个扫描器可指定扫描路径,默认的路径是再其上级目录下的所有子包会被扫描到
*/
//@SpringBootApplication(scanBasePackages= "com.boot")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.boot")
public class MainApplication {
    public static void main(String[] args) {
        //1.返回Ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);

/*        //查看里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);

        System.out.println("组件:"+(tom01 == tom02));

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println(user01 == user02);

        User user = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);

        System.out.println("用户的宠物："+(user.getPet() == tom));*/

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");

        System.out.println("haha："+haha);//true
        System.out.println("hehe："+hehe);//true

    }
}
