package sheet;

import hanon.app.controller.composer.sheet.Writer;

public class TestWriter implements Writer {
  private String content;

  @Override
  public void print(String s) {
    content = s;
  }

  @Override
  public void close() {
  }

  public String readContent() {
    return content;
  }
}
