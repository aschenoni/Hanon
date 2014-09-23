package hanon.app.model.analyst;

public abstract class StoppableTool implements Runnable {
  private volatile boolean isRunning = false;

  public void stop() {
    isRunning = false;
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
