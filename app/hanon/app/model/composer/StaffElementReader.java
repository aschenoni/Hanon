package hanon.app.model.composer;

import hanon.app.model.music.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class StaffElementReader{
	
	public static StaffElementSet loadFromFile(File file) {
    StaffElementSet set = null;
		try {
      JSONParser parser = new JSONParser();
			Object fileIn = parser.parse(new FileReader(file));
			JSONArray json = (JSONArray) fileIn;
      set = StaffElementSet.fromJSON(json);
		} catch (Exception e) {
      e.printStackTrace();
		}
		return set;
	}

}
