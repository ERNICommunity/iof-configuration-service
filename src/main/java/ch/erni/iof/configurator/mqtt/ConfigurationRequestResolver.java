package ch.erni.iof.configurator.mqtt;

import java.util.Optional;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ch.erni.iof.configurator.model.DataService;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration;

@Service
@Qualifier("resolver")
public class ConfigurationRequestResolver implements MqttCallback {

  @Autowired
  Environment environment;

  @Autowired
  private MqttClient mqttClient;

  @Autowired
  private ConfigurationPublisher configPublisher;

  @Autowired
  private DataService dataService;

  private void configureAndConnect() throws MqttSecurityException, MqttException {
    MqttConnectOptions options = new MqttConnectOptions();
    options.setWill(
        mqttClient.getTopic(environment.getProperty("topic.lwt") + environment.getRequiredProperty("device_id")),
        "I'm gone".getBytes(), 2, true);
    mqttClient.setCallback(this);
    mqttClient.connect();
    String topic = environment.getProperty("topic.configuration") + "/#";
    mqttClient.subscribe(topic);
  }

  public void enable() throws MqttSecurityException, MqttException {
    System.out.println("enable called");
    configureAndConnect();
  }

  @Override
  public void connectionLost(Throwable cause) {
    // Auto-generated method stub
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws Exception {
    String deviceId = message.toString();
    Optional<SingleAquariumConfiguration> config = dataService.getAcquariumConfiguration(deviceId);
    if (config.isPresent()) {
      configPublisher.publishConfig(config.get());
    }
    else if (!config.isPresent()) {
      SingleAquariumConfiguration singleConfig = new SingleAquariumConfiguration();
      singleConfig.setAcquariumId(deviceId);
      dataService.addConfiguration(singleConfig);
    }
  }

  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
    // Auto-generated method stub

  }
}
