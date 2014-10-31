package hanon.app.model.util;

import hanon.app.model.analyst.Observable;
import hanon.app.model.analyst.ObservableImpl;
import hanon.app.model.analyst.Observer;

public abstract class ThreadedObserverObservable<T, S> extends ThreadedObserver<T> implements Observable<S> {
  private final Observable<S> observable = new ObservableImpl<>();

  @Override
  public void register(Observer<S> observer) {
    observable.register(observer);
  }

  @Override
  public void informAll(S info) {
    observable.informAll(info);
  }
}
