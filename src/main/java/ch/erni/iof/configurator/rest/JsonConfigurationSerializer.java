package ch.erni.iof.configurator.rest;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonConfigurationSerializer extends JsonSerializer<ConfigurationsResponse> {

  @Override
  public void serialize(ConfigurationsResponse response, JsonGenerator jsonGen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    jsonGen.writeObject(response.getConfigurations());

  }

}
