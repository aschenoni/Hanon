package notes;

public class DownNoteStem extends NoteStem {
  private final int x, y;
  private final float scale;

  public DownNoteStem(int x, int y, float scale) {
    this.x = x;
    this.y = y;
    this.scale = scale;
  }

  public float scale() { return scale; }

  protected int y() {
    return y + (NoteBody.adjustedHeight(scale) / 2) + 1;
  }

  protected int x() {
    return x;
  }
}
