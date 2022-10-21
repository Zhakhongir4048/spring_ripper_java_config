package com.example.spring_ripper_java_config.quoters;

import com.example.spring_ripper_java_config.config.JavaConfigForQuoters;
import com.example.spring_ripper_java_config.quoters.annotation.Quoter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TerminatorQuoterTest {

  private static AnnotationConfigApplicationContext context;

  @BeforeAll
  static void beforeAll() {
    context = new AnnotationConfigApplicationContext(JavaConfigForQuoters.class);
  }

  @SneakyThrows
  @Test
  void sayQuote() {
    int v = 0;
    for (int i = 0; i < ++v; ) {
      Thread.sleep(100);
      context.getBean(Quoter.class).sayQuote();
    }
  }

}