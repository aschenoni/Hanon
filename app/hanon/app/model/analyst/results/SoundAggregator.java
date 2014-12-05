package hanon.app.model.analyst.results;

import java.util.ArrayList;
import java.util.List;

import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.dynamics.SoundLevels;

public class SoundAggregator implements Observer<SoundLevels>{
	
	List<SoundLevels> levels;
	
	public SoundAggregator() {
		levels = new ArrayList<SoundLevels>();
	}
	
	@Override	
	public void inform(SoundLevels info) {
		if(info != null) {
			levels.add(info);
		}
	}

	public List<SoundLevels> getLevels() {
		return levels;
	}

}
