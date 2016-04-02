package ch.erni.iof.configurator.persistence;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ch.erni.iof.configurator.model.AcquariumConfigurations;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AcquariumsConfigurationsRepository {

  private final static String CONFIGURATION_FILE = "iof_configuration.json";

  @Autowired
  ObjectMapper mapper;

  public void saveAcquariumConfigurations(Optional<AcquariumConfigurations> configurations) {
    try {
      if (configurations.isPresent()) {
        mapper.writeValue(new File(CONFIGURATION_FILE), configurations.get());
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Optional<AcquariumConfigurations> loadAcquariumConfigurations() {
    Optional<AcquariumConfigurations> configurations = Optional.empty();
    try {
      configurations = Optional.of(mapper.readValue(new File(CONFIGURATION_FILE), AcquariumConfigurations.class));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return configurations;
  }
}
