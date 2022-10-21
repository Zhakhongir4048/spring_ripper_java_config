package com.example.spring_ripper_java_config.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:value.properties")
@ComponentScan(basePackages = "com.example.spring_ripper_java_config.quoters")
public class JavaConfigForQuoters {

}