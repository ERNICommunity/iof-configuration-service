package ch.erni.iof.configurator.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds the configuration for a single acquarium.
 * 
 * @author lana
 */
public class SingleAcquariumConfiguration {

  public static class FishMapping {
    private String fishId = "";
    private String officeName = "";

    public FishMapping(final String fishId, final String officeName) {
      this.fishId = fishId;
      this.officeName = officeName;
    }

    public FishMapping() {
      // needed for deserialization
    }

    @JsonProperty("fish-id")
    public String getFishId() {
      return fishId;
    }

    public void setFishId(String fishId) {
      this.fishId = fishId;
    }

    @JsonProperty("office-name")
    public String getOfficeName() {
      return officeName;
    }

    public void setOfficeName(String officeName) {
      this.officeName = officeName;
    }
  }

  private String acquariumId;
  private List<FishMapping> fishMappings = new ArrayList<>();

  @JsonProperty("aquarium-id")
  public String getAcquariumId() {
    return acquariumId;
  }

  public void setAcquariumId(String acquariumId) {
    this.acquariumId = acquariumId;
  }

  @JsonProperty("fish-mapping")
  public List<FishMapping> getFishMappings() {
    return fishMappings;
  }

  public void setFishMappings(List<FishMapping> fishMappings) {
    this.fishMappings = fishMappings;
  }

  public void addFishMapping(final FishMapping mapping) {
    fishMappings.add(mapping);
  }
}
