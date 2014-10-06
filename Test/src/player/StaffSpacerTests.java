package player;

import hanon.app.model.player.staff.StaffSpacer;
import hanon.app.musicpiece.TwinkleTwinkleLittleStar;

public class StaffSpacerTests {
  public static void main(String[] args) {
    StaffSpacer ss = new StaffSpacer(800, TwinkleTwinkleLittleStar.elements);
    System.out.println(ss.getUnadjustedPositions());
    System.out.println(ss.getSpacings());
    System.out.println(ss.closestMeasureToWidth());
    System.out.println(ss.elementsToBeReallocated());
    System.out.println(ss.allocatedElements());
    System.out.println(ss.unallocatedElements());
  }
}
