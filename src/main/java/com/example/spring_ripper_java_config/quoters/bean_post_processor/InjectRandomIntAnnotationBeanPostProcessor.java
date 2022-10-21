package com.example.spring_ripper_java_config.quoters.bean_post_processor;

import com.example.spring_ripper_java_config.quoters.annotation.InjectRandomInt;
import java.lang.reflect.Field;
import java.util.Random;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    Field[] fields = bean.getClass().getDeclaredFields();
    for (Field field : fields) {
      InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
      if (annotation != null) {
        int min = annotation.min();
        int max = annotation.max();
        Random random = new Random();
        int number = min + random.nextInt(max - min);
        field.setAccessible(true);
        ReflectionUtils.setField(field, bean, number);
      }
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

}