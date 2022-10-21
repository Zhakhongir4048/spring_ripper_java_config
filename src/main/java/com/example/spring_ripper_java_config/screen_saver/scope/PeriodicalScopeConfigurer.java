package com.example.spring_ripper_java_config.screen_saver.scope;


import static java.time.LocalTime.now;

import com.example.spring_ripper_java_config.screen_saver.scope.pair.Pair;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class PeriodicalScopeConfigurer implements Scope {

  private final Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    if (map.containsKey(name)) {
      Pair<LocalTime, Object> pair = map.get(name);
      int secondsSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
      if (secondsSinceLastRequest > 5) {
        map.put(name, new Pair<>(now(), objectFactory.getObject()));
      }
    } else {
      map.put(name, new Pair<>(now(), objectFactory.getObject()));
    }
    return map.get(name).getValue();
  }

  @Override
  public Object remove(String name) {
    return null;
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {
  }

  @Override
  public Object resolveContextualObject(String key) {
    return null;
  }

  @Override
  public String getConversationId() {
    return null;
  }

}