package ch.erni.iof.configurator.model;

import java.util.Map;

public class AcquariumConfigurations {

  private Map<String, Map<String, String>> configurations;

  Map<String, Map<String, String>> getConfigurations() {
    return configurations;
  }

  void setConfigurations(Map<String, Map<String, String>> configurations) {
    this.configurations = configurations;
  }

  void addConfiguration(SingleAcquariumConfiguration singleConfig) {
    configurations.put(singleConfig.getAcquariumId(), singleConfig.getFishMappings());
  }

  public SingleAcquariumConfiguration getAcquariumConfiguration(String acquariumId) {
    SingleAcquariumConfiguration singleConfig = new SingleAcquariumConfiguration();
    singleConfig.setFishMappings(configurations.get(acquariumId));
    singleConfig.setAcquariumId(acquariumId);
    return singleConfig;
  }
}
