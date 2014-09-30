package librarian;

import hanon.app.model.librarian.FileRepository;

public class TestFileBrowser {

  /**
   * Make sure that the server is running before performing this test.
   */
  public static void main(String[] args) {
    FileRepository browser = new FileRepository("http://localhost:8000/");
    System.out.println(browser.getDownloadableItems());
    System.out.println(browser.getFileContent("cmajorscale.hanon"));
  }
}
