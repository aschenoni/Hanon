package hanon.app.model.analyst.evaluator;

import hanon.app.model.music.MusicNote;

public interface Evaluable {

	public void evaluate(MusicNote toCompareTo);
}
