package ch.erni.iof.configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.erni.iof.configurator.persistence.AcquariumsConfigurationsRepository;

@SpringBootApplication
public class ConfiguratorApplication {

  @Autowired
  private static AcquariumsConfigurationsRepository repo;

  public static void main(String[] args) {

    SpringApplication.run(ConfiguratorApplication.class, args);
  }
}
