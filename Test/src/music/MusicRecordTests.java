package music;

import org.junit.Test;

import static org.junit.Assert.*;

public class MusicRecordTests {
  private static final WrittenNote note = new WrittenNote(440, NoteLength.eighth);
  private static final String record = "440.0 eighth";

  @Test
  public void testWriteNote() {
    assertEquals(record, note.toString());
  }

  @Test
  public void testReadNote() {
    assertEquals(note, WrittenNote.fromString(record));
  }

  @Test
  public void testInverseReadAndWrite() {
    assertEquals(note, WrittenNote.fromString(note.toString()));
    assertEquals(record, WrittenNote.fromString(record).toString());
  }
}