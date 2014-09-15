package music;

import org.junit.Test;

import sheet.*;
import hanon.app.controller.composer.record.Recordable;
import hanon.app.controller.composer.record.RecordableSet;
import hanon.app.controller.composer.record.RecordableSetType;
import hanon.app.controller.composer.record.WrittenNote;
import hanon.app.controller.composer.sheet.Sheet;
import hanon.app.controller.music.NoteLength;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MusicRecordTests {
  private static final WrittenNote NOTE_1 = new WrittenNote(440.0f, NoteLength.eighth);
  private static final WrittenNote NOTE_2 = new WrittenNote(480.0f, NoteLength.eighth);

  private static final String NOTE_RECORD_1 = "440.0 eighth";
  private static final String NOTE_RECORD_2 = "480.0 eighth";

  private static final List<Recordable> NOTES = new ArrayList<Recordable>();
  static {
    NOTES.add(NOTE_1);
    NOTES.add(NOTE_2);
  }
  private static final RecordableSet CHORD = new RecordableSet(RecordableSetType.chord, NOTES);

  private static final String CHORD_RECORD =
          "chord {\n" +
          "\t" + NOTE_RECORD_1 + "\n" +
          "\t" + NOTE_RECORD_2 + "\n" +
          "}";

  private static final String NESTED_RECORD =
          "crescendo {\n" +
          "\tchord {\n" +
          "\t\t" + MusicRecordTests.NOTE_RECORD_1 + "\n" +
          "\t\t" + MusicRecordTests.NOTE_RECORD_2 + "\n" +
          "\t}\n" +
          "}";

  private static final String TWICE_NESTED_RECORD =
          "forte {\n" +
          "\tcrescendo {\n" +
          "\t\tchord {\n" +
          "\t\t\t" + MusicRecordTests.NOTE_RECORD_1 + "\n" +
          "\t\t\t" + MusicRecordTests.NOTE_RECORD_2 + "\n" +
          "\t\t}\n" +
          "\t}\n" +
          "}";


  private static final List<Recordable> CHORD_SET = new ArrayList<Recordable>();
  private static final List<Recordable> FORTE_SET = new ArrayList<Recordable>();

  private static final RecordableSet NESTED_SET = new RecordableSet(RecordableSetType.crescendo, CHORD_SET);
  private static final RecordableSet TWICE_NESTED_SET = new RecordableSet(RecordableSetType.forte, FORTE_SET);

  static {
    CHORD_SET.add(MusicRecordTests.CHORD);
    FORTE_SET.add(NESTED_SET);
  }

  @Test
  public void testWriteNote() {
    assertEquals(NOTE_RECORD_1, NOTE_1.record());
  }

  @Test
  public void testReadNote() {
    assertEquals(NOTE_1, WrittenNote.fromString(NOTE_RECORD_1));
  }

  @Test
  public void testInverseReadAndWriteNote() {
    assertEquals(NOTE_1, WrittenNote.fromString(NOTE_1.record()));
    assertEquals(NOTE_RECORD_1, WrittenNote.fromString(NOTE_RECORD_1).record());
  }

  @Test
  public void testWriteChord() {
    assertEquals(CHORD_RECORD, CHORD.record());
  }

  @Test
  public void testReadChord() {
    assertEquals(CHORD, RecordableSet.fromString(CHORD_RECORD));
  }

  @Test
  public void testInverseReadAndWriteChord() {
    assertEquals(CHORD, RecordableSet.fromString(CHORD.record()));
    assertEquals(CHORD_RECORD, RecordableSet.fromString(CHORD_RECORD).record());
  }

  @Test
  public void testWriteNestedSets() {
    assertEquals(NESTED_RECORD, NESTED_SET.record());
  }

  @Test
  public void testReadNestedSets() {
    assertEquals(NESTED_SET, RecordableSet.fromString(NESTED_RECORD));
  }

  @Test
  public void testWriteTwiceNestedSet() { assertEquals(TWICE_NESTED_RECORD, TWICE_NESTED_SET.record());}

  @Test
  public void testReadTwiceNestedSets() {
    assertEquals(TWICE_NESTED_SET, RecordableSet.fromString(TWICE_NESTED_RECORD));
  }

  @Test
  public void testWriteToFile() {
    TestWriter w = new TestWriter();
    Sheet s = new Sheet(CHORD);
    s.write(w);
    assertEquals(CHORD_RECORD, w.readContent());
  }

  @Test
  public void testReadFromFile() {
    TestReader r = new TestReader(CHORD_RECORD);
    Sheet s = Sheet.fromReader(r);
    assertEquals(CHORD, s.getRecord());
  }
}