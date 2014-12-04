package hanon.app.model.util;

import java.util.function.Consumer;

public class SynchronizedThread<T> extends Thread {
  private volatile boolean hasUpdate = false;
  private final Consumer<T> f;
  private T info;
  private boolean running = true;

  public SynchronizedThread(Consumer<T> f) {
    this.f = f;
    setDaemon(true);
  }

  public synchronized void update(T info) {
    this.info = info;
    hasUpdate = true;
    notify();
  }

  private synchronized boolean isRunning() {
    return running;
  }

  public synchronized void stopRunning() {
    running = false;
  }

  @Override
  public synchronized void run() {
    super.run();
    while (isRunning()) {
      while (!hasUpdate && isRunning()) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      f.accept(info);

      hasUpdate = false;
    }
  }
}
