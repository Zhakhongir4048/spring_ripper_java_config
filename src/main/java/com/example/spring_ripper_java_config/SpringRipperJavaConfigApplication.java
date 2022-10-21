package com.example.spring_ripper_java_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.spring_ripper_java_config.mock"})
public class SpringRipperJavaConfigApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRipperJavaConfigApplication.class, args);
  }

}