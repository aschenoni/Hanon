package hanon.app.controller.composer.sheet;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter implements Writer {
  private final PrintWriter pw;

  public FileWriter(String filename) {
    pw = getPrintWriter(filename);
  }

  private PrintWriter getPrintWriter(String filename) {
    PrintWriter p = null;
    try {
      p = new PrintWriter(filename);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return p;
  }

  @Override
  public void print(String s) {
    pw.print(s);
  }

  @Override
  public void close() {
    pw.close();
  }
}
