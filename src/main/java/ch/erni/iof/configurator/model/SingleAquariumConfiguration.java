package ch.erni.iof.configurator.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds the configuration for a single acquarium.
 * 
 * @author lana
 */
public class SingleAquariumConfiguration {

  public static class FishMapping {
    private String fishId = "";
    private Office office = new Office();

    public FishMapping(final String fishId, final Office office) {
      this.fishId = fishId;
      this.office = office;
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

    @JsonProperty("office")
    public Office getOffice() {
      return office;
    }

    public void setOffice(Office office) {
      this.office = office;
    }
  }

  public static class Office {
    private String officeId = "";
    private String city = "";
    private String country = "";

    public Office() {
      // needed by the Jackson library for deserialization
    }

    public Office(final String officeId, final String city, final String country) {
      this.officeId = officeId;
      this.city = city;
      this.country = country;
    }

    @JsonProperty("office-id")
    public String getOfficeId() {
      return officeId;
    }

    public void setOfficeId(String officeId) {
      this.officeId = officeId;
    }

    @JsonProperty("city")
    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }
  }

  private String acquariumId;
  private List<FishMapping> fishMappings = new ArrayList<>();
  private Office office = new Office();

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

  @JsonProperty("office")
  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }

  public void addFishMapping(final FishMapping mapping) {
    fishMappings.add(mapping);
  }
}
