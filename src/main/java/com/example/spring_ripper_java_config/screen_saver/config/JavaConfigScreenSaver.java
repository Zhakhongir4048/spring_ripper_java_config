package com.example.spring_ripper_java_config.screen_saver.config;

import com.example.spring_ripper_java_config.screen_saver.ColorFrame;
import java.awt.Color;
import java.util.Random;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example.spring_ripper_java_config.screen_saver")
public class JavaConfigScreenSaver {

  @Bean
  @Scope("periodical")
  public Color color() {
    Random random = new Random();
    return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
  }

  @Bean
  public ColorFrame colorFrame() {
    return new ColorFrame() {
      @Override
      protected Color getColor() {
        return color();
      }
    };
  }

}