package ch.erni.iof.configurator.rest;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.erni.iof.configurator.model.AquariumConfigurations;
import ch.erni.iof.configurator.model.DataService;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration;

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
  public SingleAquariumConfiguration getSingleConfiguration(@PathVariable("aquarium_id") String aquariumId) {
    return service.getAcquariumConfiguration(aquariumId);
  }

  @RequestMapping(value = "/configurations/{aquarium_id}", method = RequestMethod.POST)
  public void updateSingleConfiguration(@PathVariable("aquarium_id") String aquariumId,
      @RequestBody SingleAquariumConfiguration configuration, HttpServletResponse response) {
    boolean successfull = service.updateSingleConfiguration(configuration);
    if (!successfull) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    else {
      response.setStatus(HttpServletResponse.SC_OK);
    }
  }

  @RequestMapping(value = "/configurations/{aquarium_id}", method = RequestMethod.DELETE)
  public void deleteSingleConfiguration(@PathVariable("aquarium_id") String aquariumId) {
    // TODO
  }

  @RequestMapping("/configurations")
  public ConfigurationsResponse getAllConfigurations() {
    Optional<AquariumConfigurations> configs = service.getAllConfigurations();
    ConfigurationsResponse response = new ConfigurationsResponse();
    if (configs.isPresent()) {
      response.setConfigurations(configs.get().getConfigurations());
    }
    else {
      response.setConfigurations(new ArrayList<SingleAquariumConfiguration>());
    }
    return response;
  }
}
