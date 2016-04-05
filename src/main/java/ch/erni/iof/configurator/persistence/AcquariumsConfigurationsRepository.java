package ch.erni.iof.configurator.persistence;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.model.AcquariumConfigurations;
import ch.erni.iof.configurator.model.SingleAcquariumConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Component
public class AcquariumsConfigurationsRepository {

  private final static String CONFIGURATION_FILE = "iof_configuration.json";

  @Autowired
  ObjectMapper mapper;

  public void saveAcquariumConfigurations(Optional<AcquariumConfigurations> configurations) {
    try {
      if (configurations.isPresent()) {
        mapper.writeValue(new File(CONFIGURATION_FILE), configurations.get().getConfigurations());
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Optional<AcquariumConfigurations> loadAcquariumConfigurations() {
    Optional<AcquariumConfigurations> configurations = Optional.empty();
    try {
      List<SingleAcquariumConfiguration> aquariumList = mapper.readValue(new File(CONFIGURATION_FILE), TypeFactory
          .defaultInstance().constructCollectionType(List.class, SingleAcquariumConfiguration.class));
      AcquariumConfigurations configs = new AcquariumConfigurations();
      configs.setConfigurations(aquariumList);
      configurations = Optional.of(configs);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return configurations;
  }
}
