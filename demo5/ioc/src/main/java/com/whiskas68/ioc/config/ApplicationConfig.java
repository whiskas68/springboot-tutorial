package com.whiskas68.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.whiskas68.ioc.entity")
public class ApplicationConfig {
}
