package hanon.app.model.music;

public abstract class MusicNote implements StaffElement {
  public StaffElementType getType() {
    return StaffElementType.NOTE;
  }

  public abstract float getFrequency();

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
  public abstract int getStaffPosition();
  public abstract NoteLength getLength();
}
