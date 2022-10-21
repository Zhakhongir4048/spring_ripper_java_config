package com.example.spring_ripper_java_config.screen_saver.scope.pair;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Pair<K, V>
    implements Serializable {

  private final K key;
  private final V value;

}