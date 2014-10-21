package hanon.app.model.music;

import javafx.scene.paint.Color;
import hanon.app.model.analyst.Evaluable;

public abstract class EvaluableElement implements Evaluable, StaffElement {

	
	/**
	 * Scale showing how good or bad a note is
	 * i.e {-256 ----  0  ----- 256} with
	 * 0 as the start, 
	 * negative as bad performance,
	 * positive as a correct performance
	 */
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
