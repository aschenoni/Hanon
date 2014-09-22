package hanon.app.controller.music;

public class MusicNote implements StaffElement {
  private final NoteValue value;
  private final NoteLength length;

  protected MusicNote(NoteValue value, NoteLength length) {
    this.value = value;
    this.length = length;
  }

  public StaffElementType getType() {
    return StaffElementType.NOTE;
  }

  /**
   * The staff position is given as follows:
   * The top of the treble staff is 0. Each note below is 1 higher than the
   * previous.
   *
   *           ...
   *          -2
   * -----    -1
   *           0
   * -----     1
   *           2
   * -----     3
   *           4
   * -----     5
   *           6
   * -----     7
   *           8
   *           ...
   */
  public int getStaffPosition() {
    return value.getStaffPosition();
  }

  public NoteLength getLength() {
    return length;
  }

  public int getOctave() {
    return value.getOctave();
  }

  public NoteValue.NoteName getName() {
    return value.getName();
  }

  public NoteValue getValue() {
    return value;
  }

  public float getFrequency() {
    return value.getFrequency();
  }

  public boolean equals(Object o) {
    if (!(o instanceof MusicNote)) return false;
    else {
      MusicNote mn = (MusicNote)o;
      return getValue().equals(mn.getValue()) && getLength().equals(mn.getLength());
    }
  }

  public int hashCode() {
    return 17 * getValue().hashCode() + 17 * getLength().hashCode();
  }
}
