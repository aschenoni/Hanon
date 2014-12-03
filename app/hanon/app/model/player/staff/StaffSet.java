package hanon.app.model.player.staff;

import hanon.app.model.music.StaffElement;

import java.util.ArrayList;
import java.util.List;

/**
 * The Staff Placeable Factory is responsible for building any elements that
 * could be drawn on the music staff.
 */
public class StaffSet {
  private final List<Staff> staffs;

  public StaffSet(StaffInfo info, int dy, List<StaffElement> elements) {
    staffs = new ArrayList<>();
    List<StaffElement> temp = elements;
    boolean first = true;
    while (!temp.isEmpty()) {
      if (!first) {
        temp.add(0, info.getClef());
      }
      first = false;
      staffs.add(new Staff(info, temp));
      temp = new StaffSpacer(info.getWidth(), temp).unallocatedElements().toArrayList();
      info = info.movedDown(dy);
    }
  }

  /**
   * Takes a list of Staff Elements and correctly places their images on a
   * staff.
   */
  public List<Staff> getStaffs() {
    return staffs;
  }
}
