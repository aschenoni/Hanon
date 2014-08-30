package util;

import java.util.Arrays;

public class StringOps {

  public static String[] lines(String s) {
    return s.split("\n");
  }

  public static String unLines(String[] ss) {
    return concat(intersperse(ss, "\n"));
  }

  public static String[] intersperse(String[] ss, String toIntersperse) {
    String[] res = new String[ss.length*2];
    for (int i = 0; i < ss.length; i++) {
      res[i*2] = ss[i];
      res[i*2 + 1] = toIntersperse;
    }
    return Arrays.copyOfRange(res, 0, ss.length*2 - 1);
  }

  public static String concat(String[] ss) {
    String res = "";
    for (String s : ss) res += s;
    return res;
  }

  public static String[] prependEach(String[] ss, String toPrepend) {
    String[] res = new String[ss.length];
    for (int i = 0; i < ss.length; i++)
      res[i] = toPrepend + ss[i];
    return res;
  }

  public static String firstWord(String s) {
    return s.split("\\s")[0];
  }
}
