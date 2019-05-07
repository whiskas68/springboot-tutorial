package com.whiskas68.ioc.config;


import com.whiskas68.ioc.entity.User;
import com.whiskas68.ioc.service.UserService;
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
