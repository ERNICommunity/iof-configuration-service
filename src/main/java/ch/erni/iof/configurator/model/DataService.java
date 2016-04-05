package ch.erni.iof.configurator.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.persistence.AcquariumsConfigurationsRepository;

@Component
public class DataService {

  @Autowired
  private AcquariumsConfigurationsRepository repository;

  public Optional<AcquariumConfigurations> getAllConfigurations() {
    Optional<AcquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    return configurations;
  }

  public void addConfiguration(SingleAcquariumConfiguration singleConfig) {
    Optional<AcquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    configurations.get().getConfigurations().put(singleConfig.getAcquariumId(), singleConfig.getFishMappings());
    repository.saveAcquariumConfigurations(configurations);
  }

  public SingleAcquariumConfiguration getAcquariumConfiguration(String acquariumId) {
    Optional<AcquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    SingleAcquariumConfiguration singleConfig = new SingleAcquariumConfiguration();
    singleConfig.setFishMappings(configurations.get().getConfigurations().get(acquariumId));
    singleConfig.setAcquariumId(acquariumId);
    return singleConfig;
  }

}
