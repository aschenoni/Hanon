package music;

import org.junit.Test;
import sheet.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MusicRecordTests {
  public static final WrittenNote note1 = new WrittenNote(440.0f, NoteLength.eighth);
  public static final WrittenNote note2 = new WrittenNote(480.0f, NoteLength.eighth);

  public static final String NOTE_RECORD_1 = "440.0 eighth";
  public static final String NOTE_RECORD_2 = "480.0 eighth";

  private static final List<Recordable> notes = new ArrayList<Recordable>();
  static {
    notes.add(note1);
    notes.add(note2);
  }
  private static final RecordableSet chord = new RecordableSet(RecordableSetType.chord, notes);

  private static final String CHORD_RECORD = "chord {\n\t440.0 eighth\n\t480.0 eighth\n}";

  @Test
  public void testWriteNote() {
    assertEquals(NOTE_RECORD_1, note1.record());
  }

  @Test
  public void testReadNote() {
    assertEquals(note1, WrittenNote.fromString(NOTE_RECORD_1));
  }

  @Test
  public void testInverseReadAndWriteNote() {
    assertEquals(note1, WrittenNote.fromString(note1.record()));
    assertEquals(NOTE_RECORD_1, WrittenNote.fromString(NOTE_RECORD_1).record());
  }

  @Test
  public void testWriteChord() {
    assertEquals(CHORD_RECORD, chord.record());
  }

  @Test
  public void testReadChord() {
    assertEquals(chord, RecordableSet.fromString(CHORD_RECORD));
  }

  @Test
  public void testInverseReadAndWriteChord() {
    assertEquals(chord, RecordableSet.fromString(chord.record()));
    assertEquals(CHORD_RECORD, RecordableSet.fromString(CHORD_RECORD).record());
  }

  @Test
  public void testWriteToFile() {
    TestWriter w = new TestWriter();
    Sheet s = new Sheet(chord);
    s.write(w);
    assertEquals(CHORD_RECORD, w.readContent());
  }

  @Test
  public void testReadFromFile() {
    TestReader r = new TestReader(CHORD_RECORD);
    Sheet s = Sheet.fromReader(r);
    assertEquals(chord, s.getRecord());
  }
}