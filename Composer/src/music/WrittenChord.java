package music;

import java.util.ArrayList;
import java.util.List;

/**
 * A chord is just the representation of several notes intended to be played in
 * unison.
 */
public class WrittenChord implements Recordable {
  private final List<WrittenNote> notes;

  /**
   * Generate a chord from its string representation.
   */
  public static WrittenChord fromString(String s) {
    String[] lines = s.split("\n");
    List<WrittenNote> notes = new ArrayList<WrittenNote>();
    for (String line : lines) {
      if (isNoteLine(line)) {
        notes.add(WrittenNote.fromString(line));
      }
    }
    return new WrittenChord(notes);
  }

  private static boolean isNoteLine(String line) {
    return !(line.contains("{") || line.contains("}"));
  }

  public WrittenChord(List<WrittenNote> notes) {
    this.notes = notes;
  }

  public String record() {
    String s = "chord {\n";
    for (WrittenNote n : notes)
      s += "\t" + n.record() + "\n";
    s += "}";
    return s;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof WrittenChord))
      return false;
    else {
     WrittenChord c = (WrittenChord) o;
      return notes.equals(c.notes);
    }
  }
}
