package hanon.app.model.music;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "staffElements")
public class StaffElementSet {
  private final Clef clef;
  private final List<StaffElement> elements;

  public StaffElementSet(Clef clef, List<StaffElement> elements) {
    this.clef = clef;
    this.elements = elements;
  }

  @XmlElement(name = "staffElement")
  public List<StaffElement> getElements() {
    return elements;
  }
 
  @XmlElement(name = "clef")
  public Clef getClef() {
    return clef;
  }
}
