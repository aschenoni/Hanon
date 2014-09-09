package music;

public enum NoteLength {
  sixteenth,
  eighth,
  quarter,
  half,
  whole;

  public int getSpacing() {
    switch (this) {
      case sixteenth: return 20;
      case eighth:    return 30;
      case quarter:   return 50;
      case half:      return 80;
      case whole:     return 120;
      default:        return 20;
    }
  }
}

