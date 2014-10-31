package hanon.app.model.analyst;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl<T> implements Observable<T> {
  private final List<Observer<T>> observers = new ArrayList<>();

  public void register(Observer<T> observer) {
    observers.add(observer);
  }

  public void informAll(T info) {
    for (Observer<T> observer : observers) {
      observer.inform(info);
    }
  }
}
