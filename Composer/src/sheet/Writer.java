package sheet;

/**
 * Abstraction for something that can be written to. For example, a file.
 */
public interface Writer {

  public void print(String s);
  public void close();

}
