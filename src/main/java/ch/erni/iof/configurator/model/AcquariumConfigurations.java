package ch.erni.iof.configurator.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AcquariumConfigurations {

  private List<SingleAcquariumConfiguration> configurations = new ArrayList<>();

  public List<SingleAcquariumConfiguration> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(List<SingleAcquariumConfiguration> configurations) {
    this.configurations = configurations;
  }

}
