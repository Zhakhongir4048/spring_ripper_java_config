package com.example.spring_ripper_java_config.context;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {

  public PropertyFileApplicationContext(String fileName) {
    PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
    int i = reader.loadBeanDefinitions(fileName);
    System.out.println("found " + i + " beans");
    refresh();
  }

}