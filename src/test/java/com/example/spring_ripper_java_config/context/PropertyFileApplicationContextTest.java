package com.example.spring_ripper_java_config.context;

import com.example.spring_ripper_java_config.quoters.annotation.Quoter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PropertyFileApplicationContextTest {

  private static PropertyFileApplicationContext context;

  @BeforeAll
  static void beforeAll() {
    context = new PropertyFileApplicationContext("context.properties");
  }

  @Test
  void run() {
    context.getBean(Quoter.class).sayQuote();
  }

}