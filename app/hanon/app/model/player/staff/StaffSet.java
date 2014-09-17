package hanon.app.model.player.staff;

import hanon.app.model.music.GeneralStaffElement;
import hanon.app.model.music.StaffElement;

import java.util.ArrayList;
import java.util.List;

/**
 * The Staff Placeable Factory is responsible for building any elements that
 * could be drawn on the music staff.
 */
public class StaffSet {
  private StaffInfo info;
  private final int dy;
  private List<StaffElement> elements;

  public StaffSet(StaffInfo info, int dy, List<StaffElement> elements) {
    this.info = info;
    this.dy = dy;
    this.elements = elements;
  }

  /**
   * Takes a list of Staff Elements and correctly places their images on a
   * staff.
   */
  public List<Staff> getStaffs() {
    List<Staff> staffs = new ArrayList<Staff>();
    List<StaffElement> temp = elements;
    while (!temp.isEmpty()) {
      temp.add(0, GeneralStaffElement.clef());
      staffs.add(new Staff(info, temp));
      temp = new StaffSpacer(info.getWidth(), temp).getUnspacedElements();
      info = info.movedDown(dy);
    }
    return staffs;
  }
}
