package music;

import org.junit.Test;
import sheet.Sheet;
import sheet.TestReader;
import sheet.TestWriter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MusicRecordTests {
  private static final WrittenNote note1 = new WrittenNote(440.0f, NoteLength.eighth);
  private static final WrittenNote note2 = new WrittenNote(480.0f, NoteLength.eighth);
  private static final String noteRecord = "440.0 eighth";

  private static final List<WrittenNote> notes = new ArrayList<WrittenNote>();
  static {
    notes.add(note1);
    notes.add(note2);
  }
  private static final WrittenChord chord = new WrittenChord(notes);
  private static final String chordRecord = "chord {\n\t440.0 eighth\n\t480.0 eighth\n}";

  @Test
  public void testWriteNote() {
    assertEquals(noteRecord, note1.record());
  }

  @Test
  public void testReadNote() {
    assertEquals(note1, WrittenNote.fromString(noteRecord));
  }

  @Test
  public void testInverseReadAndWriteNote() {
    assertEquals(note1, WrittenNote.fromString(note1.record()));
    assertEquals(noteRecord, WrittenNote.fromString(noteRecord).record());
  }

  @Test
  public void testWriteChord() {
    assertEquals(chordRecord, chord.record());
  }

  @Test
  public void testReadChord() {
    assertEquals(chord, WrittenChord.fromString(chordRecord));
  }

  @Test
  public void testInverseReadAndWriteChord() {
    assertEquals(chord, WrittenChord.fromString(chord.record()));
    assertEquals(chordRecord, WrittenChord.fromString(chordRecord).record());
  }

  @Test
  public void testWriteToFile() {
    TestWriter w = new TestWriter();
    Sheet s = new Sheet(chord);
    s.writeToFile(w);
    assertEquals(chordRecord, w.readContent());
  }

  @Test
  public void testReadFromFile() {
    TestReader r = new TestReader(chordRecord);
    Sheet s = Sheet.fromReader(r);
    assertEquals(chord, s.getRecord());
  }

}