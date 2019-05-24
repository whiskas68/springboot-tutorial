# Spring Boot搭建

SpringBoot具有以下特性：

> * 更高效的创建Spring应用服务
> * 无需XML配置，可以修改默认值来满足指定需求
> * 提供额外的非业务功能性的特性，比如日志，事务，安全等

技术栈：

> * 基础框架：SpringBoot 2.1.4.RELEASE
> * 持久层：Mybatis 2.0.1
> * 数据库连接池：阿里巴巴Druid 1.1.9
> * 分页插件：pagehelper
> * 日志打印：logback

项目目录结构
```
|-src
  |-main
  |  |-resources
  |  |  |-mapper
  |  |  |  |-UserMapper.xml
  |  |  |-logback-spring.xml
  |  |  |-application.yml
  |  |  |-banner.txt
  |  |-java
  |  |  |-com
  |  |  |  |-whiskas68
  |  |  |  |  |-booter
  |  |  |  |  |  |-mapper  -- mybatis映射接口(dao层)
  |  |  |  |  |  |-util  -- 工具类
  |  |  |  |  |  |-entity  --实体类
  |  |  |  |  |  |-BooterApplication.java  -- 启动类
  |  |  |  |  |  |-service  --业务层
  |  |  |  |  |  |-config  -- 配置类
  |  |  |  |  |  |-controller  -- 控制层
  |-test
  |  |-java
  |  |  |-com
  |  |  |  |-whiskas68
  |  |  |  |  |-booter
  |  |  |  |  |  |-mapper  -- dao层测试类
  |  |  |  |  |  |-BooterApplicationTests.java  -- 测试主方法
```

环境配置
* 创建application.yml，配置服务器端口，数据库用户名和密码等信息
* 创建数据库shop, 导入sql语句config/db/sys_schema.sql和config/db/sys_data.sql
* 配置完成后，跳转到项目根目录，执行“mvn spring-boot:run”，访问http://127.0.0.1:8081/users　进行API测试

