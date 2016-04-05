package ch.erni.iof.configurator.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.erni.iof.configurator.model.AcquariumConfigurations;
import ch.erni.iof.configurator.model.DataService;
import ch.erni.iof.configurator.model.SingleAcquariumConfiguration;

/**
 * Service that handles all data requests.
 *
 */
@RestController
public class RestConfigurationController {

  @Autowired
  private DataService service;

  /**
   * 
   * @param aquariumId
   *          the aquarium id
   * @return
   */
  @RequestMapping("/configurations/{aquarium_id}")
  public SingleAcquariumConfiguration getSingleConfiguration(@PathVariable("aquarium_id") String aquariumId) {
    return service.getAcquariumConfiguration(aquariumId);
  }

  @RequestMapping("/configurations")
  public AcquariumConfigurations getAllConfigurations() {
    Optional<AcquariumConfigurations> configs = service.getAllConfigurations();
    if (configs.isPresent()) {
      return configs.get();
    }
    else {
      return new AcquariumConfigurations();
    }
  }
}
