package com.example.spring_ripper_java_config.quoters.bean_post_processor;

import com.example.spring_ripper_java_config.quoters.annotation.Profiling;
import com.example.spring_ripper_java_config.quoters.controller.ProfilingController;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProfilingHandlerAnnotationBeanPostProcessor implements BeanPostProcessor {

  private final Map<String, Class<?>> map = new HashMap<>();
  private final ProfilingController controller = new ProfilingController();

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (beanClass.isAnnotationPresent(Profiling.class)) {
      map.put(beanName, beanClass);
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName)
      throws BeansException {
    Class<?> beanClass = map.get(beanName);
    if (beanClass != null) {
      return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
          (proxy, method, args) -> {
            if (controller.isEnabled()) {
              System.out.println("Профилирую...");
              long before = System.nanoTime();
              Object retVal = method.invoke(bean, args);
              long after = System.nanoTime();
              System.out.println(after - before);
              System.out.println("Всё");
              return retVal;
            } else {
              return method.invoke(bean, args);
            }
          });
    }
    return bean;
  }

}