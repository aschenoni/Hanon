package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONObject;

import static hanon.app.model.music.StaffElementType.*;

public class GeneralStaffElement implements StaffElement {
  private final StaffElementType type;

  public static GeneralStaffElement measureLine() {
    return new GeneralStaffElement(MEASURE_LINE);
  }

  public static GeneralStaffElement staffLines() {
    return new GeneralStaffElement(STAFF_LINES);
  }

  private GeneralStaffElement(StaffElementType type) {
    this.type = type;
  }

  static GeneralStaffElement fromJSON(JSONObject jsonObj) {
    if(jsonObj.containsValue("MEASURE_LINE")){
      return measureLine();
    }
    else {
      throw new RuntimeException("No such GeneralStaffElement");
    }
  }

  @Override
  public StaffElementType getType() {
    return type;
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON("General Element", type.toString());
  }
}
