package hanon.app.model.music;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class StaffElementSet {
  private Clef clef;
  private final List<StaffElement> elements;

  public StaffElementSet(Clef clef, List<StaffElement> elements) {
    this.clef = clef;
    this.elements = elements;
  }

  public List<StaffElement> getElements() {
    return elements;
  }

  public Clef getClef() {
    return clef;  
  }
  
  public JSONArray toJSON(){
	  JSONArray array = new JSONArray();
	  JSONObject jsonClef = new JSONObject();
	  jsonClef.put("Clef", clef.toString());
	  array.add(jsonClef);
	  for(StaffElement element: elements){
		  array.add(element.toJSON());
	  }
	  return array;
  }
}

