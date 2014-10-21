package analyst;

import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.dynamics.SoundLevelMeter;
import hanon.app.model.analyst.dynamics.SoundLevels;
import hanon.app.model.util.FunctionalList;

public class SoundLevelsTests {

  public static void main(String[] args) {
    SoundLevelMeter meter = new SoundLevelMeter(100);
    LevelCollector collector = new LevelCollector();
    meter.register(collector);
    Thread t = new Thread(meter);
    t.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    meter.stop();
    System.out.println(new SoundLevels(collector.getLevels(), 5).isCrescendo());
  }

  static class LevelCollector implements Observer<Double> {
    private FunctionalList<Double> levels = FunctionalList.empty();

    @Override
    public void inform(Double info) {
      System.out.println(info);
      levels = levels.prepend(info);
    }

    public FunctionalList<Double> getLevels() {
      return levels.reverse();
    }
  }
}
