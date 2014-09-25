package hanon.app.model.composer;

import hanon.app.model.music.StaffElementSet;

import java.io.File;
import java.io.FileWriter;

import org.json.simple.JSONArray;

public class StaffElementWriter{

	static public void saveToFile(File file, StaffElementSet staffElements) {
		try {
			JSONArray json = staffElements.toJSON();
			FileWriter writer = new FileWriter(file);
			writer.write(json.toJSONString());
			writer.flush();
			writer.close();
			System.out.println("Saved");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
