package com.example.spring_ripper_java_config.quoters.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {

  Class<?> newImpl();

}