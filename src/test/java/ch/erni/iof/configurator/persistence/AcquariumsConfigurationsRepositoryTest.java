package ch.erni.iof.configurator.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.erni.iof.configurator.model.AcquariumConfigurations;
import ch.erni.iof.configurator.model.SingleAcquariumConfiguration;
import ch.erni.iof.configurator.model.SingleAcquariumConfiguration.FishMapping;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AcquariumsConfigurationsRepositoryTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void loadConfigurationTest() throws JsonGenerationException, JsonMappingException, IOException {
    SingleAcquariumConfiguration config1 = new SingleAcquariumConfiguration();
    config1.addFishMapping(new FishMapping("1", "berne"));
    config1.addFishMapping(new FishMapping("2", "zuerich"));
    config1.setAcquariumId("1234");

    SingleAcquariumConfiguration config2 = new SingleAcquariumConfiguration();
    config2.addFishMapping(new FishMapping("1", "berne"));
    config2.addFishMapping(new FishMapping("2", "zuerich"));
    config2.setAcquariumId("4321");

    List<SingleAcquariumConfiguration> configurations = new ArrayList<>();
    configurations.add(config1);
    configurations.add(config2);

    AcquariumConfigurations acqConfigs = new AcquariumConfigurations();
    acqConfigs.setConfigurations(configurations);
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File("test.json"), acqConfigs.getConfigurations());
  }
}
