package ch.erni.iof.configurator.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping(value = "/configurations/{aquarium_id}", method = RequestMethod.POST)
  public void updateSingleConfiguration(@PathVariable("aquarium_id") String aquariumId) {
    // TODO
  }

  @RequestMapping(value = "/configurations/{aquarium_id}", method = RequestMethod.DELETE)
  public void deleteSingleConfiguration(@PathVariable("aquarium_id") String aquariumId) {
    // TODO
  }

  @RequestMapping("/configurations")
  public List<SingleAcquariumConfiguration> getAllConfigurations() {
    Optional<AcquariumConfigurations> configs = service.getAllConfigurations();
    if (configs.isPresent()) {
      return configs.get().getConfigurations();
    }
    else {
      return new ArrayList<SingleAcquariumConfiguration>();
    }
  }
}
