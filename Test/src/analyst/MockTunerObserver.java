package analyst;

import hanon.app.controller.analyst.Tuner;
import hanon.app.controller.analyst.TunerInfo;
import hanon.app.controller.analyst.TunerObserver;

public class MockTunerObserver implements TunerObserver{

  @Override
  public void inform(TunerInfo info) {
    System.out.println(info);
  }

  public static void main(String [] args) throws InterruptedException {
    Tuner tuner = new Tuner(500);
    MockTunerObserver me = new MockTunerObserver();
    tuner.register(me);
    new Thread(tuner).start();
    Thread.sleep(10000);
    tuner.stop();
  }
}
