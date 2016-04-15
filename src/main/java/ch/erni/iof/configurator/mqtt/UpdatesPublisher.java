package ch.erni.iof.configurator.mqtt;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.events.UpdateEventsListener;
import ch.erni.iof.configurator.model.SingleAquariumConfiguration;

@Component
@Qualifier("updatesPublisher")
public class UpdatesPublisher implements UpdateEventsListener<SingleAquariumConfiguration> {

  @Override
  public void update(SingleAquariumConfiguration config) {
    System.out.println("updates arrived");
    // TODO send MQTT message
  }

}
