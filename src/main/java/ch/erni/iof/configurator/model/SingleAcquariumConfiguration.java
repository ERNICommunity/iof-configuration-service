package ch.erni.iof.configurator.model;

import java.util.Map;

/**
 * Holds the configuration for a single acquarium.
 * 
 * @author lana
 */
public class SingleAcquariumConfiguration {

  private String acquariumId;
  private Map<String, String> fishMappings;

  public String getAcquariumId() {
    return acquariumId;
  }

  public void setAcquariumId(String acquariumId) {
    this.acquariumId = acquariumId;
  }

  public Map<String, String> getFishMappings() {
    return fishMappings;
  }

  public void setFishMappings(Map<String, String> fishMappings) {
    this.fishMappings = fishMappings;
  }
}
