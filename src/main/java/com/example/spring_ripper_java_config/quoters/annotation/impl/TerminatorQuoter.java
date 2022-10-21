package com.example.spring_ripper_java_config.quoters.annotation.impl;

import com.example.spring_ripper_java_config.quoters.annotation.DeprecatedClass;
import com.example.spring_ripper_java_config.quoters.annotation.InjectRandomInt;
import com.example.spring_ripper_java_config.quoters.annotation.PostProxy;
import com.example.spring_ripper_java_config.quoters.annotation.Profiling;
import com.example.spring_ripper_java_config.quoters.annotation.Quoter;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
@Component
@Getter
@Setter
public class TerminatorQuoter implements Quoter {

  @InjectRandomInt(min = 2, max = 7)
  private int repeat;

  @Value("${TerminatorQuoter.message}")
  private String message;

  public TerminatorQuoter() {
    System.out.println("Фаза 1");
  }

  @PostConstruct
  public void init() {
    System.out.println("Фаза 2");
    System.out.println(repeat);
  }

  @Override
  @PostProxy
  public void sayQuote() {
    System.out.println("Фаза 3");
    for (int i = 0; i < repeat; i++) {
      System.out.println("message = " + message);
    }
  }

}