package com.example.spring_ripper_java_config.quoters.bean_factory_post_processor;


import com.example.spring_ripper_java_config.quoters.annotation.DeprecatedClass;
import java.util.Objects;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@Deprecated
public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
      String beanClassName = beanDefinition.getBeanClassName();
      try {
        Class<?> beanClass = Class.forName(beanClassName);
        DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
        if (Objects.nonNull(annotation)) {
          beanDefinition.setBeanClassName(annotation.newImpl().getName());
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

}