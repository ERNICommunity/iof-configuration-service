package ch.erni.iof.configurator.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AcquariumConfigurations {

  private Map<String, Map<String, String>> configurations = new HashMap<String, Map<String, String>>();

  public Map<String, Map<String, String>> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(Map<String, Map<String, String>> configurations) {
    this.configurations = configurations;
  }

}
