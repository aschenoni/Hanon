package components;

public class DownNoteStem extends NoteStem {
  private final int baseX, baseY;
  private final float scale;

  public DownNoteStem(int x, int y, float scale) {
    this.baseX = x;
    this.baseY = y;
    this.scale = scale;
  }

  public float scale() { return scale; }

  protected int y() {
    return baseY + (NoteBody.adjustedHeight(scale) / 2) + 1;
  }

  protected int x() {
    return baseX;
  }
}
