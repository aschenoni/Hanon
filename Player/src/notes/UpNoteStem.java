package notes;

public class UpNoteStem extends NoteStem {
  private final int x, y;
  private final float scale;

  public UpNoteStem(int x, int y, float scale) {
    this.x = x;
    this.y = y;
    this.scale = scale;
  }

  public float scale() { return scale; }

  protected int y() {
    return y - height() + (NoteBody.adjustedHeight(scale) / 2) + 1;
  }

  protected int x() {
    return x + NoteBody.adjustedWidth(scale) - width();
  }
}
