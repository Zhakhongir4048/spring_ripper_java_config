package com.example.spring_ripper_java_config.screen_saver.scope.bean_factory_post_processor;

import com.example.spring_ripper_java_config.screen_saver.scope.PeriodicalScopeConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomScopeRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    beanFactory.registerScope("periodical", new PeriodicalScopeConfigurer());
  }

}