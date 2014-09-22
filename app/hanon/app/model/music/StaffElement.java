package hanon.app.model.music;

import org.json.simple.JSONObject;

public interface StaffElement {
  StaffElementType getType();
  
  JSONObject toJSON();
}
