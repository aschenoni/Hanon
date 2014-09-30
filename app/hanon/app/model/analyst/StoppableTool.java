package hanon.app.model.analyst;

import java.util.ArrayList;
import java.util.List;

public abstract class StoppableTool<T> implements Runnable {
  private volatile boolean isRunning = false;

  private final List<Observer<T>> observers = new ArrayList<>();

  public void stop() {
    isRunning = false;
  }

  protected boolean isStopped() {
    return !isRunning;
  }

  @Override
  public void run() {
    isRunning = true;
    while (isRunning) {
      runLoop();
    }
  }

  public void register(Observer<T> observer) {
    observers.add(observer);
  }

  protected void informAll(T info) {
    for (Observer<T> observer : observers) {
      observer.inform(info);
    }
  }

  protected abstract void runLoop();
}
