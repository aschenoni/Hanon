package hanon.app.model.analyst;

import hanon.app.model.util.Operator;

public abstract class StoppableTool<T> extends ObservableImpl<T> implements Runnable {
  private volatile boolean isRunning = false;
  private Operator onStop = () -> { };

  public void start() {
    isRunning = true;
    Thread t = new Thread(this);
    t.setDaemon(true);
    t.start();
  }

  public void stop() {
    isRunning = false;
    onStop.operate();
  }

  public void setOnStop(Operator onStop) {
    this.onStop = onStop;
  }

  protected boolean isStopped() {
    return !isRunning;
  }

  @Override
  public void run() {
    while (isRunning) {
      runLoop();
    }
  }

  protected abstract void runLoop();
}
