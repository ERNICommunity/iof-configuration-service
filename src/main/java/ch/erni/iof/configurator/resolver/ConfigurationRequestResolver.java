package ch.erni.iof.configurator.resolver;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ConfigurationRequestResolver implements MqttCallback {

  @Autowired
  Environment environment;

  @Autowired
  private MqttClient mqttClient;

  private void configureAndConnect() throws MqttSecurityException, MqttException {
    MqttConnectOptions options = new MqttConnectOptions();
    options.setWill(mqttClient.getTopic(environment.getProperty("topic.lwt")), "I'm gone".getBytes(), 2, true);
    mqttClient.setCallback(this);
    mqttClient.connect();
    mqttClient.subscribe(environment.getProperty("topic.configuration"));
  }

  @Override
  public void connectionLost(Throwable cause) {
    // TODO Auto-generated method stub

  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
    // TODO Auto-generated method stub

  }

}
