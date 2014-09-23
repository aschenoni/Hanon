package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONArray;

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

    array.add(JSONUtil.stringsToJSON("Clef", clef.toString()));
	  for(StaffElement element: elements){
		  array.add(element.toJSON());
	  }
	  return array;
  }
}

