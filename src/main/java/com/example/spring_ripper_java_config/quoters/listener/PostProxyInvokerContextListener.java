package com.example.spring_ripper_java_config.quoters.listener;

import com.example.spring_ripper_java_config.quoters.annotation.PostProxy;
import java.lang.reflect.Method;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

  // Главная фабрика Spring
  private final ConfigurableListableBeanFactory factory;

  @Autowired
  public PostProxyInvokerContextListener(ConfigurableListableBeanFactory factory) {
    this.factory = factory;
  }

  @SneakyThrows
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    ApplicationContext context = event.getApplicationContext();
    String[] names = context.getBeanDefinitionNames();
    for (String name : names) {
      BeanDefinition beanDefinition = factory.getBeanDefinition(name);
      String originalClassName = beanDefinition.getBeanClassName();
      Class<?> originalClass = Class.forName(originalClassName);
      Method[] methods = originalClass.getMethods();
      for (Method method : methods) {
        if (method.isAnnotationPresent(PostProxy.class)) {
          Object bean = context.getBean(name);
          Method currentMethod = bean.getClass()
              .getMethod(method.getName(), method.getParameterTypes());
          currentMethod.invoke(bean);
        }
      }
    }
  }

}