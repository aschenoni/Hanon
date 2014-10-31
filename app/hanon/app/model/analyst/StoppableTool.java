package hanon.app.model.analyst;

public abstract class StoppableTool<T> extends ObservableImpl<T> implements Runnable {
  private volatile boolean isRunning = false;

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

  protected abstract void runLoop();
}
