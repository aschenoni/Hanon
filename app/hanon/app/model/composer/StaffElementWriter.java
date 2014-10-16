package hanon.app.model.composer;

import hanon.app.model.music.StaffElementSet;
import hanon.app.model.music.jsonutil.JSONWriter;

import java.io.File;
import java.io.FileWriter;

import org.json.simple.JSONArray;

public class StaffElementWriter{

	static public void saveToFile(File file, StaffElementSet staffElements) {
		try {
			JSONArray json = staffElements.toJSON();
			JSONWriter.write(file, json);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
