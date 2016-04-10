package ch.erni.iof.configurator.persistence;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.model.AquariumConfigurations;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Component
public class AcquariumsConfigurationsRepository {

  private final static String CONFIGURATION_FILE = "iof_configuration.json";

  @Autowired
  ObjectMapper mapper;

  public void saveAcquariumConfigurations(Optional<AquariumConfigurations> configurations) {
    try {
      if (configurations.isPresent()) {
        mapper.writeValue(new File(CONFIGURATION_FILE), configurations.get().getConfigurations());
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Optional<AquariumConfigurations> loadAcquariumConfigurations() {
    Optional<AquariumConfigurations> configurations = Optional.empty();
    try {
      List<SingleAquariumConfiguration> aquariumList = mapper.readValue(new File(CONFIGURATION_FILE), TypeFactory
          .defaultInstance().constructCollectionType(List.class, SingleAquariumConfiguration.class));
      AquariumConfigurations configs = new AquariumConfigurations();
      configs.setConfigurations(aquariumList);
      configurations = Optional.of(configs);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return configurations;
  }
}
