package ch.erni.iof.configurator.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.events.UpdateEventsListener;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Qualifier("configPublisher")
public class ConfigurationPublisher implements UpdateEventsListener<SingleAquariumConfiguration> {

  @Autowired
  Environment environment;

  @Autowired
  private MqttClient mqttClient;

  @Override
  public void update(SingleAquariumConfiguration config) {
    System.out.println("updates arrived");
    try {
      publishConfig(config);
    }
    catch (JsonProcessingException | MqttException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void publishConfig(SingleAquariumConfiguration config) throws JsonProcessingException,
      MqttPersistenceException, MqttException {
    if (config != null && checkForValidConfig(config)) {
      ObjectMapper mapper = new ObjectMapper();
      final String configJson = mapper.writeValueAsString(config);
      final MqttTopic configTopic = mqttClient.getTopic(environment.getProperty("topic.configuration") + "/"
          + config.getAcquariumId());

      configTopic.publish(new MqttMessage(configJson.getBytes()));
    }

  }

  private boolean checkForValidConfig(SingleAquariumConfiguration config) {
    String officeId = config.getOffice().getOfficeId();
    if (officeId.isEmpty() || "".equals(officeId)) {
      return false;
    }
    return true;
  }
}
