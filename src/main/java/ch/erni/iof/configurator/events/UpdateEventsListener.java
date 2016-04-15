package ch.erni.iof.configurator.events;

public interface UpdateEventsListener<T> {

  void update(T config);
}
