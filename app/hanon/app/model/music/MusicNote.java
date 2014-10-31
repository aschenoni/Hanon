package hanon.app.model.music;

import javafx.scene.paint.Color;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.Yin;
import hanon.app.model.music.jsonutil.JSONUtil;
import hanon.app.model.util.FunctionalList;
import org.json.simple.JSONObject;

public class MusicNote extends EvaluableElement {

  public static MusicNote fromSoundArr(float[] floatArr) {
    Yin pitch = new Yin(8000, 1024);
    PitchDetectionResult pdr = pitch.getPitch(floatArr);
    return new MusicNote(new NoteValue(pdr.getPitch()), NoteLength.QUARTER); //TODO how do we determine note length
  }

  static MusicNote fromJSON(JSONObject jsonObj) {
    NoteLength length = NoteLength.valueOf((String) jsonObj.get("NoteLength"));
    String note = (String) jsonObj.get("NoteValue");
    NoteValue.NoteName noteName = NoteValue.NoteName.valueOf(note.substring(0, 1));
    Integer octave = new Integer(note.substring(1));
    NoteValue value = NoteValue.fromNameAndOctave(noteName, octave);
    return new MusicNote(value, length);
  }

  private final NoteValue value;
  private final NoteLength length;

  public MusicNote(NoteValue value, NoteLength length) {
    this.value = value;
    this.length = length;
  }

  public MusicNote(NoteValue value, NoteLength length, Color color) {
	  this.value = value;
	  this.length = length;
  }
  
  public StaffElementType getType() {
    return StaffElementType.NOTE;
  }

  /**
   * The staff position is given as follows:
   * The top of the treble staff is 0. Each note below is 1 higher than the
   * previous.
   *
   *           ...
   *          -2
   * -----    -1
   *           0
   * -----     1
   *           2
   * -----     3
   *           4
   * -----     5
   *           6
   * -----     7
   *           8
   *           ...
   */
  public int getStaffPosition(Clef clef) {
    return value.getStaffPosition(clef);
  }

  public NoteLength getLength() {
    return length;
  }

  public int getOctave() {
    return value.getOctave();
  }

  public NoteValue.NoteName getName() {
    return value.getName();
  }

  NoteValue getValue() {
    return value;
  }

  public float getFrequency() {
    return value.getFrequency();
  }

  public boolean equals(Object o) {
    if (!(o instanceof MusicNote)) return false;
    else {
      MusicNote mn = (MusicNote)o;
      return getValue().equals(mn.getValue()) && getLength().equals(mn.getLength());
    }
  }

  public int hashCode() {
    return 17 * getValue().hashCode() + 17 * getLength().hashCode();
  }

  public String toString() {
    return "Value: " + getValue() + ", Length: " + getLength();
  }

  @Override
  public JSONObject toJSON() {
    return JSONUtil.stringsToJSON(
            "NoteValue", getValue().toString(),
            "NoteLength", getLength().toString());
  }


  public float getFrequencyOffset(MusicNote toCompareTo) {
    return getValue().getFrequency() - toCompareTo.getFrequency();
  }

  /**
   * @return the difference between the actual note frequency and the closest
   * theoretical note frequency.
   *
   * Example: a 450 Hz note would yield 10, because the closest theoretical
   * note is 440 Hz (A4)
   */
  public float getFrequencyOffset() {
    return getFrequencyOffset(new MusicNote(
            NoteValue.fromNameAndOctave(getName(), getOctave()),
            getLength()
    ));
  }

  @Override
  public void evaluate(MusicNote toCompareTo) {
    float offset = getFrequencyOffset(toCompareTo);
  }

  public static MusicNote average(FunctionalList<MusicNote> noteList) {
    Float frequency = FunctionalList.average(noteList.map(MusicNote::getFrequency).filter(f -> f > 0));
    return new MusicNote(new NoteValue(frequency), NoteLength.QUARTER); //TODO how do we determine the length
		
	}
}
