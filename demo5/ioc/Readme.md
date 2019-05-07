##### Ioc容器简介：
Spring Ioc容器，一个管理bean的容器，将相互依赖的对象之间进行解耦

在spring boot中我们主要通过装配bean到容器中。下面通过注解的方式，使用AnnotationConfigApplicationContxt, 来实现一个简单的例子。

* 定义一个POJO对象 User
```java
package com.whiskas68.ioc.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String desc;
}
```

* 接着定义一个java配置类ApplicationConfig
```java
package com.whiskas68.ioc.config;
import com.whiskas68.ioc.entity.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean(name="User")
    public User initUser(){
        User user = new User();
        user.setId(1L);
        user.setName("whiskas68");
        user.setDesc("管理员");
        return user;
    }
}
```
备注：@Configuration表示这是一个Java配置文件，spring容器会根据它来生成容器去装配bean，@Bean表示将initUser方法返回的POJO对象装配到Ioc容器中，属性name定义该bean名称为"User"。
至此，我们就可以使用AnnotationConfigApplicatonContext来自定义容器。

* 创建一个类IocTest
```java
package com.whiskas68.ioc.config;


import com.whiskas68.ioc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IocTest {

    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                ApplicationConfig.class
        );

        User user = ctx.getBean(User.class);
        log.info("bean 创建成功");
        log.info("bean id为：" + user.getId());
    }
}
```
输出结果：
```shell
14:28:53.294 [main] INFO com.whiskas68.ioc.config.IocTest - bean 创建成功
14:28:53.294 [main] INFO com.whiskas68.ioc.config.IocTest - bean id为：1
```

###### 通过扫描的方式装配Bean
复用之前的User类，并加入注解@Component
```java
package com.whiskas68.ioc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@Component("user")
public class User implements Serializable {

    @Value("1")
    private Long id;

    @Value("whiskas68")
    private String name;

    @Value("管理员")
    private String desc;
}
```
注解@Component表明这个类被ioc容器扫描装配，注解@Value指定具体的值，使ioc注入相应的属性值。为了让ioc容器装配这个类，需要改写ApplicationConfig:
```java
package com.whiskas68.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.whiskas68.ioc.entity")
public class ApplicationConfig {
}
```
加入@ComponentScan，扫描所在的包。然后进行测试,这样就可以运行了
