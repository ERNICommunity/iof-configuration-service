package ch.erni.iof.configurator.rest;

import java.util.List;

import ch.erni.iof.configurator.model.SingleAquariumConfiguration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = JsonConfigurationSerializer.class)
public class ConfigurationsResponse {

  private List<SingleAquariumConfiguration> configurations;

  public List<SingleAquariumConfiguration> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(List<SingleAquariumConfiguration> configurations) {
    this.configurations = configurations;
  }
}
