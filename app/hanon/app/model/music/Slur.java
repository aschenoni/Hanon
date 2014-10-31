package hanon.app.model.music;

import hanon.app.model.analyst.evaluator.Evaluable;
import hanon.app.model.music.jsonutil.JSONUtil;

import org.json.simple.JSONObject;

public class Slur implements StaffElement {
  private final int numNotes;

  public Slur(int numNotes) {
    this.numNotes = numNotes;
  }

  public int getNumNotes() {
    return numNotes;
  }

  @Override
  public StaffElementType getType() {
    return StaffElementType.SLUR;
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON("Slur", Integer.toString(numNotes));
  }

  public static StaffElement fromJSON(JSONObject jsonObj) {
    int numNotes = Integer.parseInt((String)jsonObj.get("Slur"));
    return new Slur(numNotes);
  }

}
