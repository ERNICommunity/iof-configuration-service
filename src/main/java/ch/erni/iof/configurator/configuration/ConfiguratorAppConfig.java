package ch.erni.iof.configurator.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("ch.erni.iof.configurator")
@PropertySource(value = { "classpath:application.properties" })
public class ConfiguratorAppConfig {
  private String brokerUrl;
  private String clientId;

  @Autowired
  private Environment environment;

  @Bean
  public MqttClient mqttClient() throws MqttException, FileNotFoundException, IOException {
    this.brokerUrl = environment.getRequiredProperty("broker_url") + ":"
        + environment.getRequiredProperty("broker_port");
    this.clientId = environment.getRequiredProperty("device_id");
    return new MqttClient(brokerUrl, clientId);
  }

  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

    jsonConverter.setObjectMapper(objectMapper);
    return jsonConverter;
  }

}
