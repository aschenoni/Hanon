package hanon.app.model.analyst.dynamics;

import hanon.app.model.util.FunctionalList;

public class SoundLevels {
  private final FunctionalList<Double> levels;
  private final int granularity;

  public SoundLevels(FunctionalList<Double> levels, int granularity) {
    this.levels = levels;
    this.granularity = granularity;
  }

  public boolean isCrescendo() {
    FunctionalList<FunctionalList<Double>> grouped = levels.groupN(granularity);
    FunctionalList<Double> averages = grouped.map(SoundLevels::average);
    return isOrdered(averages);
  }

  private static double average(FunctionalList<Double> list) {
    Double sum = list.foldl((a, b) -> a + b, 0.0);
    return sum / list.size();
  }

  public static boolean isOrdered(FunctionalList<Double> list) {
    if (list.isEmpty()) return true;
    else if (list.tail().isEmpty()) return true;
    else {
      if (list.head() < list.tail().head()) return isOrdered(list.tail());
      else return false;
    }
  }
}
