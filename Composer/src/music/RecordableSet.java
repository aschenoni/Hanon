package music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.StringOps.*;

public class RecordableSet implements Recordable {
  private final RecordableSetType type;
  private final List<Recordable> elements;

  public static RecordableSet fromString(String s) {
    String[] lines = trimAll(lines(s));
    RecordableSetType type = RecordableSetType.valueOf(firstWord(lines[0]));
    List<Recordable> elements = getElements(Arrays.copyOfRange(lines, 1, lines.length-1));
    return new RecordableSet(type, elements);
  }

  private static List<Recordable> getElements(String[] lines) {
    List<Recordable> elements = new ArrayList<Recordable>();
    String[] groups = groupIntoSets(lines);
    for (String group : groups) {
      if (isNoteLine(group)) elements.add(WrittenNote.fromString(group));
      else                   elements.add(fromString(group));
    }
    return elements;
  }

  private static boolean isNoteLine(String line) {
    return !(line.contains("{") || line.contains("}"));
  }

  public RecordableSet(RecordableSetType type, List<Recordable> elements) {
    this.type = type;
    this.elements = elements;
  }

  @Override
  public String record() {
    String s = type.toString() + " {\n";
    for (Recordable r : elements)
      s += unLines(prependEach(lines(r.record()), "\t")) + "\n";
    return s + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof RecordableSet)) return false;
    else {
      RecordableSet s = (RecordableSet) o;
      return s.type.equals(type) && s.elements.equals(elements);
    }
  }

  @Override
  public int hashCode() {
    return (17 * type.hashCode()) + (31 * elements.hashCode());
  }
}
