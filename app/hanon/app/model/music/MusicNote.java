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
    
    	if(jsonObj.get("NoteColor") != null)
    	{
    		Long rawColor = Long.parseLong(((String) jsonObj.get("NoteColor")).substring(2), 16);
    		Long red =     rawColor & 0xff000000;
    		System.out.println(red);
    		red = red >> 6*4;
    		System.out.println(red);
    		Long green =   rawColor & 0x00ff0000;
    		green = green >> 4*4;
    		Long blue =    rawColor & 0x0000ff00;
    		blue = blue >> 2*4;
    		Long opacity = rawColor & 0x000000ff;

    		Color color = new Color(red.doubleValue()/255, green.doubleValue()/255, blue.doubleValue()/255, opacity.doubleValue()/255);
    		return new MusicNote(value, length, color);
    	}
    	
   return new MusicNote(value, length); 
   }

  private final NoteValue value;

  private final NoteLength length;
  
  private Color noteColor;

  public MusicNote(NoteValue value, NoteLength length) {
    this.value = value;
    this.length = length;
    this.noteColor = Color.BLACK;
  }

  public MusicNote(NoteValue value, NoteLength length, Color color) {
	  this.value = value;
	  this.length = length;
	  this.noteColor = color;
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

  public Color getColor() {
	  return noteColor;
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
            "NoteLength", getLength().toString(),
            "NoteColor", getColor().toString());
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

    int eval = 0; //TODO add threshold to evaluate to: 1 for good, 0 for default, -1 for bad
    switch (eval) {
      case 1: noteColor = new Color(255,0,0,1); //RED
      case -1: noteColor = new Color(0,255,150,1); //custom green color that is calmer than just pure green
      default: noteColor = Color.BLACK;
    }
  }

  public static MusicNote average(FunctionalList<MusicNote> noteList) {
    Float frequency = FunctionalList.average(noteList.map(MusicNote::getFrequency).filter(f -> f > 0));
    return new MusicNote(new NoteValue(frequency), NoteLength.QUARTER); //TODO how do we determine the length
		
	}

  public void setColor(Color color) {
    this.noteColor = color;
  }
}
