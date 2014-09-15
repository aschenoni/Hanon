package hanon.app.controller.composer.util;

import java.util.Arrays;

public class StringOps {

  /**
   * Split a string into multiple strings at the newline character.
   */
  public static String[] lines(String s) {
    return s.split("\n");
  }

  /**
   * Join a list of strings by interspersing newline characters.
   */
  public static String unlines(String[] ss) {
    return concat(intersperse(ss, "\n"));
  }

  /**
   * Put a string value between every pair of string values in a given list.
   *
   * intersperse({"this", "is", "test"}, "||") -> {"this", "||", "is", "||", "test"}
   */
  private static String[] intersperse(String[] ss, String toIntersperse) {
    String[] res = new String[ss.length*2];
    for (int i = 0; i < ss.length; i++) {
      res[i*2] = ss[i];
      res[i*2 + 1] = toIntersperse;
    }
    return Arrays.copyOfRange(res, 0, ss.length*2 - 1);
  }

  /**
   * Combine all the strings in a list into one string.
   */
  private static String concat(String[] ss) {
    String res = "";
    for (String s : ss) res += s;
    return res;
  }

  /**
   * Prepend every item in a list of strings with a given string.
   *
   * prependEach({"Hello", "World"}, "Why, ") -> {"Why, Hello", "Why, World"}
   */
  public static String[] prependEach(String[] ss, String toPrepend) {
    String[] res = new String[ss.length];
    for (int i = 0; i < ss.length; i++)
      res[i] = toPrepend + ss[i];
    return res;
  }

  /**
   * Gets the first word in a string by splitting by spaces.
   */
  public static String firstWord(String s) {
    return s.split("\\s")[0];
  }

  /**
   * Trims leading whitespace in every string in an array.
   */
  public static String[] trimAll(String[] ss) {
    String[] trimmed = new String[ss.length];
    for (int i = 0; i < ss.length; i++) trimmed[i] = ss[i].trim();
    return trimmed;
  }

  /**
   * Groups sets together based on braces.
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
  public static String[] groupIntoSets(String[] ss) {
    SetGrouper sg = new SetGrouper(ss);
    sg.group();
    return sg.getGroups();
  }
}
