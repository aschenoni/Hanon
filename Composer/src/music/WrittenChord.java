package music;

import java.util.ArrayList;
import java.util.List;

public class WrittenChord {
  private final List<WrittenNote> notes;

  public static WrittenChord fromString(String chordRecord) {
    String[] lines = chordRecord.split("\n");
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

  public List<WrittenNote> getNotes() {
    return notes;
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
