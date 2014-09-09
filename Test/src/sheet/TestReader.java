package sheet;

public class TestReader implements Reader {
  private final String content;

  public TestReader(String content) {
    this.content = content;
  }

  @Override
  public String getContent() {
    return content;
  }
}
