package components;

public class DownNoteStem extends NoteStem {
  private final int baseX, baseY;

  public DownNoteStem(int x, int y) {
    this.baseX = x;
    this.baseY = y;
  }

  protected int adjustedY() {
    return baseY + (NoteBody.HEIGHT / 2) + 1;
  }

  protected int adjustedX() {
    return baseX;
  }
}
