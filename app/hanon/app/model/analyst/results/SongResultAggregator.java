package hanon.app.model.analyst.results;

import java.util.ArrayList;
import java.util.List;

import hanon.app.controller.EvaluationController;
import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.dynamics.SoundLevels;
import hanon.app.model.analyst.tuner.MusicNoteEvaluation;

public class SongResultAggregator implements Observer<MusicNoteEvaluation> {

	public int evaluations;
	int[] goodBadNon; //good notes, bad notes, unplayed notes
	private List<MusicNoteEvaluation> list;
	
	private EvaluationController evalController;
	
	public SongResultAggregator() {
		evaluations = 0;
		list = new ArrayList();
		goodBadNon = new int[3];
	}
	
	public void inform(MusicNoteEvaluation info) {
		evaluations++;
		
		if(info == null) {
			publish();
		} else {
			
			if(info.isGood()) {
				goodBadNon[0]++;
			} else if(info.isPoor() ) {
				goodBadNon[1]++;
			} else {
				goodBadNon[2]++;
			}
			list.add(info);
		}
		
		//System.out.println(info);
	}
	
	//public void inform(SoundLevels level) {
	//	
	//}
	
	public void setEvalController(EvaluationController evalController) {
		this.evalController = evalController;
	}
	
	private void publish() {
		evalController.publish(new SongResult(list,goodBadNon) );
	}
	

}
