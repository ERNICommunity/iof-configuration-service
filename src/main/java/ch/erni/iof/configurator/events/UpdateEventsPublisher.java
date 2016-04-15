package ch.erni.iof.configurator.events;

import java.util.ArrayList;
import java.util.List;

public class UpdateEventsPublisher<T> {
  private List<UpdateEventsListener<T>> observers = new ArrayList<>();

  public void attack(UpdateEventsListener<T> observer) {
    observers.add(observer);
  }

  public void detach(UpdateEventsListener<T> observer) {
    observers.contains(observer);
  }

  public void notifyAllObservers(T config) {
    for (UpdateEventsListener<T> observer : observers) {
      observer.update(config);
    }
  }

}
