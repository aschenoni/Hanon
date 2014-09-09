package music;

public class TimeSignature {
  private final int beatsPerMeasure;
  private final int whichGetsBeat;

  private int num256Notes;

  public TimeSignature(int beatsPerMeasure, int whichGetsBeat) {
    this.beatsPerMeasure = beatsPerMeasure;
    this.whichGetsBeat = whichGetsBeat;
  }

  public int getBeatsPerMeasure() {
    return beatsPerMeasure;
  }

  public int getWhichGetsBeat() {
    return whichGetsBeat;
  }

  public void addNote(NoteLength length) {
    this.num256Notes += length.lengthRelativeTo256th();
    if (this.num256Notes == max256Notes())
      this.num256Notes = 0;
  }

  private int max256Notes() {
    return NoteLength.fromInt(whichGetsBeat).lengthRelativeTo256th() * beatsPerMeasure;
  }

  public boolean needsNewMeasure() {
    return num256Notes == 0;
  }
}
