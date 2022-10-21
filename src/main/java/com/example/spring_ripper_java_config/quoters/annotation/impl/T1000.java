package com.example.spring_ripper_java_config.quoters.annotation.impl;

import com.example.spring_ripper_java_config.quoters.annotation.Quoter;

public class T1000 extends TerminatorQuoter implements Quoter {

  @Override
  public void sayQuote() {
    System.out.println("Я ЖИДКИЙ");
  }

}