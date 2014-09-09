package sheet;

import music.Recordable;
import music.RecordableSet;
import music.WrittenNote;

/**
 * A sheet is the representation of some recordable content. The sheet abstracts
 * the recordable in such a way that they can easily be read from and written to
 * different storage formats.
 */
public class Sheet {
  private final Recordable content;

  /**
   * Reads the sheet from some recordable format, as defined by the reader.
   */
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


  /**
   * Writes the sheet to some recordable format, as defined by the writer.
   */
  public void write(Writer writer) {
    writer.print(content.record());
    writer.close();
  }

  public Recordable getRecord() {
    return content;
  }
}
