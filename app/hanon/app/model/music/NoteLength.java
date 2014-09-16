package hanon.app.model.music;

public enum NoteLength {
  twoFiftySixth,
  oneTwentyEighth,
  sixtyForth,
  thirtySecond,
  sixteenth,
  eighth,
  quarter,
  half,
  whole;

  public static NoteLength fromInt(int i) {
    switch (i) {
      case 256: return twoFiftySixth;
      case 128: return oneTwentyEighth;
      case 64:  return sixtyForth;
      case 32:  return thirtySecond;
      case 16:  return sixteenth;
      case 8:   return eighth;
      case 4:   return quarter;
      case 2:   return half;
      case 1:   return whole;
      default:  throw new NoSuchLengthException();
    }
  }

  public int lengthRelativeTo256th() {
    return (int) Math.pow(2, index());
  }

  private int index() {
    for (int i = 0; i < NoteLength.values().length; i++)
      if (NoteLength.values()[i] == this) return i;
    return -1;
  }

  private static class NoSuchLengthException extends RuntimeException {
  }
}

