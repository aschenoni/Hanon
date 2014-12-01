package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONObject;

public class Crescendo implements StaffElement {
  private final int numNotes;

  public Crescendo(int numNotes) {
    this.numNotes = numNotes;
  }

  public int getNumNotes() {
    return numNotes;
  }

  @Override
  public StaffElementType getType() {
    return StaffElementType.CRESCENDO;
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON("Crescendo", Integer.toString(numNotes));
  }

  public static StaffElement fromJSON(JSONObject jsonObj) {
    int numNotes = Integer.parseInt((String)jsonObj.get("Crescendo"));
    return new Crescendo(numNotes);
  }
}
