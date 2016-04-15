package ch.erni.iof.configurator.events;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ch.erni.iof.configurator.model.SingleAquariumConfiguration;

@Component
@Qualifier("updateEventsPublisher")
public class UpdateEventsPublisherImpl extends UpdateEventsPublisher<SingleAquariumConfiguration> {

}
