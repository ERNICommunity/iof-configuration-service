package ch.erni.iof.configurator.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.erni.iof.configurator.model.AquariumConfigurations;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration.FishMapping;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration.Office;

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
    SingleAquariumConfiguration config1 = new SingleAquariumConfiguration();
    config1.addFishMapping(new FishMapping("1", new Office("1", "Berne", "CH")));
    config1.addFishMapping(new FishMapping("2", new Office("2", "Zuerich", "CH")));
    config1.setAcquariumId("1234");
    config1.setOffice(new Office("1", "Berne", "CH"));

    SingleAquariumConfiguration config2 = new SingleAquariumConfiguration();
    config2.addFishMapping(new FishMapping("1", new Office("1", "Berne", "CH")));
    config2.addFishMapping(new FishMapping("2", new Office("2", "Zuerich", "CH")));
    config2.setAcquariumId("4321");
    config2.setOffice(new Office("2", "Zuerich", "CH"));

    List<SingleAquariumConfiguration> configurations = new ArrayList<>();
    configurations.add(config1);
    configurations.add(config2);

    AquariumConfigurations acqConfigs = new AquariumConfigurations();
    acqConfigs.setConfigurations(configurations);
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File("test.json"), acqConfigs.getConfigurations());
  }
}
