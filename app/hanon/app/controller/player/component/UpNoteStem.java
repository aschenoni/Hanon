package hanon.app.controller.player.component;

public class UpNoteStem extends NoteStem {
  private final int baseX, baseY;

  public UpNoteStem(int x, int y) {
    this.baseX = x;
    this.baseY = y;
  }

  protected int adjustedY() {
    return baseY - NoteStem.HEIGHT + (NoteBody.HEIGHT / 2);
  }

  protected int adjustedX() {
    return baseX - NoteStem.WIDTH + NoteBody.WIDTH;
  }
}
