package hanon.app.model.util;

import hanon.app.model.analyst.Observer;

import java.util.function.Consumer;

public abstract class ThreadedObserver<T> implements Observer<T> {
  private final SynchronizedThread<T> thread;

  public ThreadedObserver() {
    thread = new SynchronizedThread<>(this::consume);
    thread.start();
  }

  @Override
  public void inform(T info) {
    thread.update(info);
  }

  public abstract void consume(T t);

  public void stop() {
    thread.stopRunning();
  }
}
