package hanon.app.model.music;

import static hanon.app.model.music.StaffElementType.*;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class GeneralStaffElement implements StaffElement {
  private final StaffElementType type;

  public static GeneralStaffElement clef() {
    return new GeneralStaffElement(CLEF);
  }

  public static GeneralStaffElement measureLine() {
    return new GeneralStaffElement(MEASURE_LINE);
  }

  public static GeneralStaffElement staffLines() {
    return new GeneralStaffElement(STAFF_LINES);
  }

  private GeneralStaffElement(StaffElementType type) {
    this.type = type;
  }

  @Override
  public StaffElementType getType() {
    return type;
  }

@Override
public JSONObject toJSON() {
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("General Element", this.type.toString());
	return new JSONObject(map);
}

}
