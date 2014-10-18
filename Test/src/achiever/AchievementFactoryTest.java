package achiever;

import java.io.File;

import hanon.app.model.achiever.AchievementFactory;

public class AchievementFactoryTest {

	public static void main(String[] args)
	{
		File file = new File("config/Achievements.txt");
		System.out.println(file.getAbsolutePath());
		AchievementFactory.genAchievements(file);
	}
	
}
