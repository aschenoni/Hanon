package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONObject;

public class TimeSignature implements StaffElement {
  private final int beatsPerMeasure;
  private final int whichGetsBeat;

  private int num256Notes;

  public TimeSignature(int beatsPerMeasure, int whichGetsBeat) {
    this.beatsPerMeasure = beatsPerMeasure;
    this.whichGetsBeat = whichGetsBeat;
  }

  public int getBeatsPerMeasure() {
    return beatsPerMeasure;
  }

  public int getWhichGetsBeat() {
    return whichGetsBeat;
  }

  public void addNote(NoteLength length) {
    this.num256Notes += length.lengthRelativeTo256th();
    if (this.num256Notes == max256Notes())
      this.num256Notes = 0;
  }

  private int max256Notes() {
    return NoteLength.fromInt(whichGetsBeat).lengthRelativeTo256th() * beatsPerMeasure;
  }

  public boolean needsNewMeasure() {
    return num256Notes == 0;
  }

  @Override
  public StaffElementType getType() {
    return StaffElementType.TIME_SIGNATURE;
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON(
            "TimeSignature", beatsPerMeasure + ":" + whichGetsBeat);
  }

  public static TimeSignature fromJSON(JSONObject jsonObj) {
    String s = jsonObj.get("TimeSignature").toString();
    String[] info = s.split(":");
    int beatsPerMeasure = Integer.parseInt(info[0]);
    int whichGetsBeat = Integer.parseInt(info[1]);
    return new TimeSignature(beatsPerMeasure, whichGetsBeat);
  }
}
