package components;

public class UpNoteStem extends NoteStem {
  private final int baseX, baseY;
  private final float scale;

  public UpNoteStem(int x, int y, float scale) {
    this.baseX = x;
    this.baseY = y;
    this.scale = scale;
  }

  public float scale() { return scale; }

  protected int y() {
    return baseY - height() + (NoteBody.adjustedHeight(scale) / 2);
  }

  protected int x() {
    return baseX + NoteBody.adjustedWidth(scale) - width();
  }
}
