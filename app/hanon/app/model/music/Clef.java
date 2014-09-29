package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONObject;

public enum Clef implements StaffElement {
  BASS,
  TREBLE;

  @Override
  public StaffElementType getType() {
    return StaffElementType.CLEF;
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON("Clef", toString());
  }
}
