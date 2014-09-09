package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for grouping sets together based on braces.
 *
 * For example
 *
 * "item 1\n
 *  group 1 {\n
 *    item 2\n
 *    item 3\n
 *  }" ->
 *
 * {
 *   "item 1",
 *
 *   "group 1 {\n
 *      item 2\n
 *      item 3\n
 *    }"
 * }
 *
 */
class SetGrouper {
  private final String[] ss;
  private final List<String> groups = new ArrayList<String>();

  private int depth = 0;
  private String currentSet = "";

  public SetGrouper(String[] ss) {
    this.ss = ss;
  }

  public String[] group() {
    for (String s : ss) {
      if (isOpeningTag(s))      addOpeningSet(s);
      else if (isEndOfSet(s))   finishSet(s);
      else if (isClosingTag(s)) addClosingTag(s);
      else if (inSet())         addLine(s);
      else                      groups.add(s);
    }
    return getGroups();
  }

  public String[] getGroups() {
    String[] res = new String[groups.size()];
    return groups.toArray(res);
  }

  private boolean inSet() {
    return depth > 0;
  }

  private void addLine(String s) {
    currentSet += s + "\n";
  }

  private void addClosingTag(String s) {
    depth--;
    addLine(s);
  }

  private boolean isEndOfSet(String s) {
    return isClosingTag(s) && depth == 1;
  }

  private void finishSet(String s) {
    depth--;
    currentSet += s;
    groups.add(currentSet);
    currentSet = "";
  }

  private void addOpeningSet(String s) {
    depth++;
    addLine(s);
  }

  private static boolean isOpeningTag(String s) {
    return s.contains("{");
  }

  private static boolean isClosingTag(String s) {
    return s.contains("}");
  }
}