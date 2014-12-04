package hanon.app.model.achiever;

public class Medal {
	
	private enum MedalRank {
		GOLD(100,95), SILVER(95,75), BRONZE(75,60), NOMEDAL(60,-1);	
		int upperBound;
		int lowerBound;
		MedalRank(int upper, int lower) {
			upperBound = upper;
			lowerBound = lower;
		}
	};
	
	private MedalRank rank;
	
	public Medal(float percentGood) {
		for(MedalRank md: MedalRank.values()) {
			if(md.upperBound >= percentGood && md.lowerBound < percentGood) {
				rank = md;
			}
		}
	}

}
