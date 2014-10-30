package hanon.app.model.util;

import hanon.app.model.analyst.Observer;

import java.util.function.Consumer;

public class ThreadedObserver<T> implements Observer<T> {
  private final SynchronizedThread<T> thread;

  public ThreadedObserver(Consumer<T> f) {
    thread = new SynchronizedThread<>(f);
    thread.start();
  }

  @Override
  public void inform(T info) {
    thread.update(info);
  }
}
