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
    return isOrdered(averagedLevels());
  }

  public boolean isDecrescendo() {
    return isOrdered(averagedLevels().reverse());
  }

  private FunctionalList<Double> averagedLevels() {
    FunctionalList<Double> withoutOutliers = dropOutliers(levels);
    FunctionalList<FunctionalList<Double>> grouped = withoutOutliers.groupN(granularity);
    return grouped.map(SoundLevels::average);
  }

  private FunctionalList<Double> dropOutliers(FunctionalList<Double> levels) {
    Double mean = average(levels);
    Double sd = stdDev(levels);
    return levels.filter(n -> Math.abs(n - mean) < sd);
  }

  private Double stdDev(FunctionalList<Double> nums) {
    Double mean = average(nums);
    Double summedDiffs = nums.foldl((sum, n) -> sum + ((n - mean) * (n - mean)), 0.0);
    return Math.sqrt(summedDiffs/nums.size());
  }

  private static Double average(FunctionalList<Double> list) {
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
