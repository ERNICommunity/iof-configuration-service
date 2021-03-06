package ch.erni.iof.configurator.configuration;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.events.UpdateEventsPublisher;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration;
import ch.erni.iof.configurator.mqtt.ConfigurationPublisher;
import ch.erni.iof.configurator.mqtt.ConfigurationRequestResolver;

/**
 * Handles all startup/initialization
 *
 */
@Component
public class StartupEventListener implements ApplicationListener<ContextRefreshedEvent> {

  private boolean notInitialized = true;

  @Autowired
  private ConfigurationRequestResolver resolver;

  @Autowired
  private UpdateEventsPublisher<SingleAquariumConfiguration> updateEventsPublisher;

  @Autowired
  private ConfigurationPublisher configPublisher;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (notInitialized) {
      try {
        resolver.enable();
        updateEventsPublisher.attack(configPublisher);
      }
      catch (MqttException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      notInitialized = false;
    }
  }
}
