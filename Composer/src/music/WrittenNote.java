package music;

/**
 * A written note is the implementation of a music note that is represented by
 * a frequency and a length. It can be written out to a format that can be used
 * for file storage.
 */
public class WrittenNote implements MusicNote {
  private final float frequency;
  private final NoteLength length;

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
    return new WrittenNote(frequency, length);
  }

  public WrittenNote(float frequency, NoteLength length) {
    this.frequency = frequency;
    this.length = length;
  }

  public float getFrequency() {
    return frequency;
  }

  public NoteLength getLength() {
    return length;
  }

  public String toString() {
    return frequency + " " + length.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof WrittenNote))
      return false;
    else {
      WrittenNote n = (WrittenNote) o;
      return (n.frequency == frequency && n.length == length);
    }
  }

  @Override
  public int hashCode() {
    int hash = 1;
    hash = (hash * 17) + (int)(100*frequency);
    hash = (hash * 17) + length.hashCode();
    return hash;
  }
}
