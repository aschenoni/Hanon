package hanon.app.model.composer.sheet;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader implements Reader {
  private final String filename;

  public FileReader(String filename) {
    this.filename = filename;
  }

  @Override
  public String getContent() {
    try {
      return readFile();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  private String readFile() throws IOException {
    BufferedReader reader = new BufferedReader(new java.io.FileReader(filename));

    String line;
    String s = "";
    while((line = reader.readLine()) != null) s += line + "\n";
    reader.close();

    return removeFinalNewline(s);
  }

  private String removeFinalNewline(String s) {
    return s.substring(0, s.length()-1);
  }
}
