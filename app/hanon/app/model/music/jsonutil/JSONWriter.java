package hanon.app.model.music.jsonutil;

import hanon.app.model.music.StaffElementSet;

import java.io.File;
import java.io.FileWriter;

import org.json.simple.JSONArray;

public class JSONWriter {
	static public void write(File file, JSONArray json) {
		try {
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
