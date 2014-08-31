package music;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordableSetTests {

  public static final String NESTED_RECORD = "crescendo {\n\tchord {\n\t\t440.0 whole\n\t\t480.0 whole\n\t}\n}";
  private static final String TWICE_NESTED_RECORD =
          "forte {\n\tcrescendo {\n\t\tchord {\n\t\t\t440.0 whole\n\t\t\t480.0 whole\n\t\t}\n\t}\n}";
  public static final WrittenNote NOTE1 = new WrittenNote(440.0f, NoteLength.whole);

  public static final WrittenNote NOTE2 = new WrittenNote(480.0f, NoteLength.whole);
  public static final List<Recordable> NOTES = new ArrayList<Recordable>();
  public static final List<Recordable> CHORD_SET = new ArrayList<Recordable>();
  public static final List<Recordable> FORTE_SET = new ArrayList<Recordable>();

  public static final RecordableSet CHORD = new RecordableSet(RecordableSetType.chord, NOTES);
  public static final RecordableSet NESTED_SET = new RecordableSet(RecordableSetType.crescendo, CHORD_SET);
  public static final RecordableSet TWICE_NESTED_SET = new RecordableSet(RecordableSetType.forte, FORTE_SET);

  static {
    NOTES.add(NOTE1);
    NOTES.add(NOTE2);
    CHORD_SET.add(CHORD);
    FORTE_SET.add(NESTED_SET);
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
}
