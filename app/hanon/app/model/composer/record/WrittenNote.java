package hanon.app.model.composer.record;

import java.util.HashMap;

import org.json.simple.JSONObject;

import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteLength;
import hanon.app.model.music.NoteValue;

/**
 * A written note is the implementation of a music note that is represented by
 * a frequency and a length. It can be written out to a format that can be used
 * for file storage.
 */
public class WrittenNote extends MusicNote implements Recordable {

  /**
   * Generate a written note from a string representation. The string
   * representation should be as follows: "{frequency length}. The frequency
   * is a decimal number and the length is a String found in NoteLength.
   * For example: "440.0 eighth"
   */
  public static WrittenNote fromString(String s) {
    String[] words = s.split(" ");
    float frequency = Float.parseFloat(words[0]);
    NoteLength length = NoteLength.valueOf(words[1]);
    NoteValue value = new NoteValue(frequency);
    return new WrittenNote(value, length);
  }

  public WrittenNote(NoteValue value, NoteLength length) {
    super(value, length);
  }

  public WrittenNote(float frequency, NoteLength length) {
    this(new NoteValue(frequency), length);
  }

  @Override
  public String record() {
    return getFrequency()+ " " + getLength().toString();
  }

@Override
public JSONObject toJSON() {
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("NoteValue", this.value.toString());
	map.put("NoteLength", this.length.toString());
	
	
	return new JSONObject(map);
}
}
