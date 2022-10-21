package com.example.spring_ripper_java_config.quoters;

import com.example.spring_ripper_java_config.config.JavaConfigForQuoters;
import com.example.spring_ripper_java_config.quoters.annotation.Quoter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TerminatorQuoterTest2 {

  private static AnnotationConfigApplicationContext context;

  @BeforeAll
  static void beforeAll() {
    context = new AnnotationConfigApplicationContext(JavaConfigForQuoters.class);
  }

  @Test
  void sayQuote() {
    context.getBean(Quoter.class);
  }

}