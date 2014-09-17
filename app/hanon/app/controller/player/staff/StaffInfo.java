package hanon.app.controller.player.staff;

import hanon.app.controller.music.Clef;

public class StaffInfo {
  private final Clef clef;
  private final int x;
  private final int y;
  private final int width;
  private final int measureLineHeight;

  private StaffInfo(Clef clef, int x, int y, int width, int measureLineHeight) {
    this.clef = clef;
    this.x = x;
    this.y = y;
    this.width = width;
    this.measureLineHeight = measureLineHeight;
  }

  public Clef getClef() {
    return clef;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getMeasureLineHeight() {
    return measureLineHeight;
  }

  public StaffInfo movedDown(int dy) {
    return new StaffInfo(clef, x, y+dy, width, measureLineHeight);
  }

  public static class StaffInfoBuilder {
    private Clef clef = null;
    private int x = Integer.MIN_VALUE;
    private int y = Integer.MIN_VALUE;
    private int width = Integer.MIN_VALUE;
    private int measureLineHeight = 4*Staff.LINE_GAP;

    public StaffInfo build() {
      if (clef == null ||
              x == Integer.MIN_VALUE ||
              y == Integer.MIN_VALUE ||
              width == Integer.MIN_VALUE ||
              measureLineHeight == Integer.MIN_VALUE)
        throw new RuntimeException("StaffInfo improperly initialized");
      return new StaffInfo(clef, x, y, width, measureLineHeight);
    }

    public StaffInfoBuilder clef(Clef clef) {
      this.clef = clef;
      return this;
    }

    public StaffInfoBuilder x(int x) {
      this.x = x;
      return this;
    }

    public StaffInfoBuilder y(int y) {
      this.y = y;
      return this;
    }

    public StaffInfoBuilder width(int width) {
      this.width = width;
      return this;
    }

    public StaffInfoBuilder measureLineHeight(int measureLineHeight) {
      this.measureLineHeight = measureLineHeight;
      return this;
    }
  }
}
