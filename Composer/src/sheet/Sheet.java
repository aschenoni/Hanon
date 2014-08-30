package sheet;

import music.Recordable;
import music.RecordableSet;
import music.WrittenNote;

public class Sheet {
  private final Recordable content;

  public static Sheet fromReader(Reader r) {
    String s = r.getContent();
    String[] lines = s.split("\n");

    Recordable content;
    if (lines[0].contains("{")) content = RecordableSet.fromString(s);
    else                        content = WrittenNote.fromString(s);
    return new Sheet(content);
  }

  public Sheet(Recordable content) {
    this.content = content;
  }

  public void writeToFile(Writer writer) {
    writer.print(content.record());
    writer.close();
  }

  public Recordable getRecord() {
    return content;
  }
}
