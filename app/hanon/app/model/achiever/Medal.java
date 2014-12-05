package hanon.app.model.achiever;

import java.awt.Image;
import java.io.File;

import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;



public class Medal {
	
	private enum MedalRank {
		GOLD(100,95,"res/images/Gold.png"), SILVER(95,75,"res/images/Silver.png"),
			BRONZE(75,60,"res/images/Bronze.png"), NOMEDAL(60,-1,"res/images/NoMedal.png");
		int upperBound;
		int lowerBound;
		String url;
		
		MedalRank(int upper, int lower, String url) {
			upperBound = upper;
			lowerBound = lower;
			this.url = url;
		}
	};
	
	private MedalRank rank;

	public ImageView medalImg;
	
	public Medal(float percentGood) {
		for(MedalRank md: MedalRank.values()) {
			if(md.upperBound >= percentGood && md.lowerBound < percentGood) {
				rank = md;
			}
		}
		
		try {
      File file = new File(rank.url);
			medalImg = new ImageView(file.toURI().toString());
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	public ImageView getMedalImage() {
		return medalImg;
	}

}
