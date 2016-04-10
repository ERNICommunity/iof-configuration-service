package ch.erni.iof.configurator.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AquariumConfigurations {

  private List<SingleAquariumConfiguration> configurations = new ArrayList<>();

  public List<SingleAquariumConfiguration> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(List<SingleAquariumConfiguration> configurations) {
    this.configurations = configurations;
  }

}
