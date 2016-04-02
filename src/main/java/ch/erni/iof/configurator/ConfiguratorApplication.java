package ch.erni.iof.configurator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.erni.iof.configurator.model.AcquariumConfigurations;
import ch.erni.iof.configurator.persistence.AcquariumsConfigurationsRepository;

@SpringBootApplication
public class ConfiguratorApplication {

  @Autowired
  private static AcquariumsConfigurationsRepository repo;

  private static void run() {
    AcquariumConfigurations configs = new AcquariumConfigurations();
    Map<String, Map<String, String>> configurations = new HashMap<String, Map<String, String>>();
    Map<String, String> config = new HashMap<String, String>();
    config.put("1", "berne");
    config.put("2", "zuerich");
    configurations.put("1234", config);

    repo.saveAcquariumConfigurations(Optional.of(configs));
  }

  public static void main(String[] args) {
    run();
    // public static void main(String[] args) {
    SpringApplication.run(ConfiguratorApplication.class, args);
  }
}
