package hanon.app.model.analyst.results;

import hanon.app.model.achiever.Medal;
import hanon.app.model.analyst.dynamics.SoundLevels;
import hanon.app.model.analyst.tuner.MusicNoteEvaluation;

import java.util.Arrays;
import java.util.List;

public class SongResult {
	
	private List<MusicNoteEvaluation> list;
	private int[] goodBadNon;
	private List<SoundLevels> levels;
	private Medal medal;
	
	public SongResult(List<MusicNoteEvaluation> list, int[] goodBadNon, List<SoundLevels> levels) {
		this.list = list;
		this.goodBadNon = goodBadNon;
		this.levels = levels;

		medal = medalEarned();
	}
	
	public Medal medalEarned() {
		float percentGood = (float) goodBadNon[0] / Arrays.stream(goodBadNon).sum();
		percentGood *= 100;
		percentGood = Math.round(percentGood);
		return new Medal(percentGood);
	}
	
	public int[] getGBN() {
		return goodBadNon;				
	}

	public List<SoundLevels> getLevels() {
		
		return levels;
	}
}
