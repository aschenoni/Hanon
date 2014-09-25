package hanon.app.model.analyst.rhythm;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Clicker implements RhythmObserver, Runnable {

  public static final File AUDIO = new File("res\\audio\\click.wav");

  private Clip clip;

  @Override
  public void inform() {
    clip.setFramePosition(0);
    clip.start();
  }

  @Override
  public void run() {
    try {
      AudioInputStream inputStream = AudioSystem.getAudioInputStream(AUDIO);
      clip = AudioSystem.getClip();
      clip.open(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
