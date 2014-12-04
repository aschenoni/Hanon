package hanon.app.model.analyst.results;

import hanon.app.model.achiever.Medal;
import hanon.app.model.analyst.tuner.MusicNoteEvaluation;

import java.util.Arrays;
import java.util.List;

public class SongResult {
	
	private List<MusicNoteEvaluation> list;
	private int[] goodBadNon;
	private Medal medal;
	
	public SongResult(List<MusicNoteEvaluation> list, int[] goodBadNon) {
		this.list = list;
		this.goodBadNon = goodBadNon;
		medal = medalEarned();
	}
	
	public Medal medalEarned() {
		float percentGood = (float) goodBadNon[0] / Arrays.stream(goodBadNon).sum();
		percentGood *= 100;
		percentGood = Math.round(percentGood);
		return new Medal(percentGood);
	}

}
