package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONObject;

public class Decrescendo implements StaffElement {
  private final int numNotes;

  public Decrescendo(int numNotes) {
    this.numNotes = numNotes;
  }

  public int getNumNotes() {
    return numNotes;
  }

  @Override
  public StaffElementType getType() {
    return StaffElementType.DECRESCENDO;
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON("Decrescendo", Integer.toString(numNotes));
  }

  public static StaffElement fromJSON(JSONObject jsonObj) {
    int numNotes = Integer.parseInt((String)jsonObj.get("Decrescendo"));
    return new Decrescendo(numNotes);
  }
}
