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
    configurations.get().getConfigurations().add(singleConfig);
    repository.saveAcquariumConfigurations(configurations);
  }

  public SingleAcquariumConfiguration getAcquariumConfiguration(String acquariumId) {
    SingleAcquariumConfiguration singleConfig = new SingleAcquariumConfiguration();
    singleConfig.setAcquariumId(acquariumId);
    Optional<AcquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    if (!configurations.isPresent()) {
      return singleConfig;
    }

    for (SingleAcquariumConfiguration single : configurations.get().getConfigurations()) {
      if (single.getAcquariumId().equals(acquariumId)) {
        return single;
      }
    }
    return singleConfig;
  }

}
