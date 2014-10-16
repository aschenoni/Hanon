package hanon.app.model.composer;

import hanon.app.model.music.*;
import hanon.app.model.music.jsonutil.JSONReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StaffElementReader{
	
	public static StaffElementSet loadFromFile(File file) {
    
	JSONArray json = JSONReader.read(file);
    return StaffElementSet.fromJSON(json);
	}

}
