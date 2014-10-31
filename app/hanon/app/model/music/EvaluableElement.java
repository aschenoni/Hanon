package hanon.app.model.music;

import javafx.scene.paint.Color;
import hanon.app.model.analyst.evaluator.Evaluable;

public abstract class EvaluableElement implements Evaluable, StaffElement {

	public int evaluation = 0;
	
	/**
	 * The color with which to present the note as
	 */
	public Color color = Color.BLACK;
	
	/**
	 * the duration for which to evaluate the element
	 */
	public NoteLength length;
	
	public NoteLength getLength()
	{
		return length;
	}

  public abstract float getFrequency();
}
