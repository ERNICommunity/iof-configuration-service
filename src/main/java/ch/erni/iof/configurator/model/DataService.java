package ch.erni.iof.configurator.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.persistence.AcquariumsConfigurationsRepository;

@Component
public class DataService {

  @Autowired
  private AcquariumsConfigurationsRepository repository;

  public Optional<AquariumConfigurations> getAllConfigurations() {
    Optional<AquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    return configurations;
  }

  public void addConfiguration(SingleAquariumConfiguration singleConfig) {
    Optional<AquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    configurations.get().getConfigurations().add(singleConfig);
    repository.saveAcquariumConfigurations(configurations);
  }

  public SingleAquariumConfiguration getAcquariumConfiguration(String acquariumId) {
    SingleAquariumConfiguration singleConfig = new SingleAquariumConfiguration();
    singleConfig.setAcquariumId(acquariumId);
    Optional<AquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    if (!configurations.isPresent()) {
      return singleConfig;
    }

    for (SingleAquariumConfiguration single : configurations.get().getConfigurations()) {
      if (single.getAcquariumId().equals(acquariumId)) {
        return single;
      }
    }
    return singleConfig;
  }

  public boolean updateSingleConfiguration(final SingleAquariumConfiguration configuration) {
    System.out.println("Message received");
    Optional<AquariumConfigurations> configurations = repository.loadAcquariumConfigurations();
    Optional<SingleAquariumConfiguration> configOptional = findConfiguration(configurations,
        configuration.getAcquariumId());
    if (!configOptional.isPresent()) {
      return false;
    }
    configOptional.get().setFishMappings(configuration.getFishMappings());
    configOptional.get().setOffice(configuration.getOffice());
    repository.saveAcquariumConfigurations(configurations);
    return true;
  }

  private Optional<SingleAquariumConfiguration> findConfiguration(
      final Optional<AquariumConfigurations> configurations, final String aquariumId) {
    if (!configurations.isPresent()) {
      return Optional.empty();
    }
    for (SingleAquariumConfiguration single : configurations.get().getConfigurations()) {
      if (single.getAcquariumId().equals(aquariumId)) {
        return Optional.of(single);
      }
    }
    return Optional.empty();
  }
}
