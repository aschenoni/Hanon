package hanon.app.model.music;

import org.json.simple.JSONObject;

public class Chord implements StaffElement {
  private final MusicNote[] notes;

  public Chord(MusicNote... notes) {
    this.notes = notes;
  }

  public MusicNote[] getNotes() {
    return notes;
  }

  @Override
  public StaffElementType getType() {
    return StaffElementType.CHORD;
  }
  
  @Override
  public JSONObject toJSON() {
    return null; //TODO
  }
}
