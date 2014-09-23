package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONObject;

public class Rest implements StaffElement {
  private final NoteLength length;

  public Rest(NoteLength length) {
    this.length = length;
  }

  public NoteLength getLength() {
    return length;
  }

  @Override
  public StaffElementType getType() {
    return StaffElementType.REST;
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON("RestLength", length.toString());
  }
}
