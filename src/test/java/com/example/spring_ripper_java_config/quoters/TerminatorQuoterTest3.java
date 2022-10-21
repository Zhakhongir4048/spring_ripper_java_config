package com.example.spring_ripper_java_config.quoters;

import com.example.spring_ripper_java_config.config.JavaConfigForQuoters;
import com.example.spring_ripper_java_config.quoters.annotation.Quoter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TerminatorQuoterTest3 {

  private static AnnotationConfigApplicationContext context;

  @BeforeAll
  static void beforeAll() {
    context = new AnnotationConfigApplicationContext(JavaConfigForQuoters.class);
  }

  @SneakyThrows
  @Test
  void sayQuote() {
    Quoter bean = context.getBean(Quoter.class);
    int count = 0;
    while (count != 4) {
      Thread.sleep(1000);
      bean.sayQuote();
      count++;
    }
  }

}