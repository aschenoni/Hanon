package hanon.app.model.librarian;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * A file browser is meant for interacting with a website of the following
 * layout:
 *
 * The main page gives a list of all downloadable files.
 *
 * The /res/{file} returns the file
 */
public class FileRepository {
  private final String rootUrl;

  public FileRepository(String rootUrl) {
    this.rootUrl = rootUrl;
  }

  public List<String> getDownloadableItems() {
    return Arrays.asList(getContent(rootUrl).split(","));
  }

  public String getFileContent(String filename) {
    return getContent(rootUrl + "res/" + filename);
  }

  private String getContent(String url) {
    return doRead(getBufferedReader(url));
  }

  private BufferedReader getBufferedReader(String url) {
    try {
      return new BufferedReader(new InputStreamReader(new URL(url).openStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private String doRead(BufferedReader in) {
    String s;
    String res = "";
    try {
      while ((s = in.readLine()) != null) res += s;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return res;
  }
}
