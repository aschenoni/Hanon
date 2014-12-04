package hanon.app.model.analyst;

import hanon.app.model.util.FunctionalList;

import java.util.ArrayList;
import java.util.List;

public abstract class Collector<T> extends StoppableTool<T> {
  private FunctionalList<T> collection;

  public Collector() {
    this.collection = FunctionalList.empty();
    start();
  }

  protected synchronized void addToCollection(T item) {
    collection = collection.prepend(item);
  }

  /**
   * Gets the collection of music notes and resets the one in the collector.
   */
  public synchronized FunctionalList<T> takeCollection() {
    FunctionalList<T> copy = collection;
    collection = FunctionalList.empty();
    return copy.reverse();
  }

  public synchronized T getMostRecent() {
    return collection.head();
  }

  private final List<Observer<T>> observers = new ArrayList<>();

  @Override
  public void register(Observer<T> observer) {
    observers.add(observer);
  }

  @Override
  public void informAll(T info) {
    for (Observer<T> obs: observers)
      obs.inform(info);
  }
}
