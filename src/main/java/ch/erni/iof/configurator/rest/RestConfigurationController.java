package ch.erni.iof.configurator.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.erni.iof.configurator.model.SingleAcquariumConfiguration;

@RestController
public class RestConfigurationController {

  /**
   * Implementation not finished. Only for playing ...
   * 
   * @param aquariumId
   *          the aquarium id
   * @return
   */
  @RequestMapping("/configurations/{aquarium_id}")
  public SingleAcquariumConfiguration getSingleConfiguration(@PathVariable("aquarium_id") String aquariumId) {
    SingleAcquariumConfiguration config = new SingleAcquariumConfiguration();
    config.setAcquariumId(aquariumId);
    return config;
  }

}
