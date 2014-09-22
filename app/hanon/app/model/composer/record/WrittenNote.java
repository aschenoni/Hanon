package hanon.app.model.composer.record;

import hanon.app.model.music.Clef;
import hanon.app.model.music.MusicNote;
import hanon.app.model.music.NoteLength;
import hanon.app.model.music.NoteValue;

/**
 * A written note is the implementation of a music note that is represented by
 * a frequency and a length. It can be written out to a format that can be used
 * for file storage.
 */
public class WrittenNote extends MusicNote implements Recordable {
  private final NoteValue value;
  private final NoteLength length;

  /**
   * Generate a written note from a string representation. The string
   * representation should be as follows: "{frequency length}. The frequency
   * is a decimal number and the length is a String found in NoteLength.
   * For example: "440.0 EIGHTH"
   */
  public static WrittenNote fromString(String s) {
    String[] words = s.split(" ");
    float frequency = Float.parseFloat(words[0]);
    NoteLength length = NoteLength.valueOf(words[1]);
    NoteValue value = new NoteValue(frequency);
    return new WrittenNote(value, length);
  }

  public WrittenNote(NoteValue value, NoteLength length) {
    this.value = value;
    this.length = length;
  }

  public WrittenNote(float frequency, NoteLength length) {
    this(new NoteValue(frequency), length);
  }

  public float getFrequency() {
    return value.getFrequency();
  }

  public NoteLength getLength() {
    return length;
  }

  @Override
  public String record() {
    return getFrequency()+ " " + length.toString();
  }

  @Override
  public int getStaffPosition(Clef clef) {
    return value.getStaffPosition(clef);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof WrittenNote))
      return false;
    else {
      WrittenNote n = (WrittenNote) o;
      return (n.value.equals(value) && n.length == length);
    }
  }

  @Override
  public int hashCode() {
    int hash = 1;
    hash = (hash * 17) + value.hashCode();
    hash = (hash * 17) + length.hashCode();
    return hash;
  }
}