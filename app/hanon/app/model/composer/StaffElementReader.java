package hanon.app.model.composer;

import hanon.app.model.music.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StaffElementReader{
	
	public static StaffElementSet loadFromFile(File file) {
    JSONArray json = getJsonArray(file);
    return StaffElementSet.fromJSON(json);
	}

  private static JSONArray getJsonArray(File file) {
    JSONParser parser = new JSONParser();
    Object fileIn = null;
    try {
      fileIn = parser.parse(new FileReader(file));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return (JSONArray) fileIn;
  }

}
