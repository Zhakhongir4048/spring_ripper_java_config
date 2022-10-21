package com.example.spring_ripper_java_config.screen_saver;

import com.example.spring_ripper_java_config.screen_saver.config.JavaConfigScreenSaver;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ColorFrameTest {

  @SneakyThrows
  @Test
  void showOnRandomPlace() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        JavaConfigScreenSaver.class);
    int count = 0;
    while (count != 100) {
      context.getBean(ColorFrame.class).showOnRandomPlace();
      Thread.sleep(100);
      count++;
    }
  }

}