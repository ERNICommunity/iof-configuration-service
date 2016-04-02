package ch.erni.iof.configurator.persistence;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    Map<String, Map<String, String>> configurations = new HashMap<String, Map<String, String>>();
    Map<String, String> config1 = new HashMap<String, String>();
    config1.put("1", "berne");
    config1.put("2", "zuerich");
    configurations.put("1234", config1);

    Map<String, String> config2 = new HashMap<String, String>();
    config2.put("1", "berne");
    config2.put("2", "zuerich");
    configurations.put("4321", config2);

    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File("test.json"), configurations);
    // fail("not yet implemented");
  }
}
