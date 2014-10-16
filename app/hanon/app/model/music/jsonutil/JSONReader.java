package hanon.app.model.music.jsonutil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	  public static JSONArray read(File file) {
		    JSONParser parser = new JSONParser();
		    Object fileIn = null;
		    try {
		      fileIn = parser.parse(new FileReader(file));
		    } catch (IOException | ParseException e) {
		      e.printStackTrace();
		    }
		    return (JSONArray) fileIn;
		  }
}
