package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.Observer;
import hanon.app.model.music.EvaluableElement;
import hanon.app.model.music.NoteLength;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Clicker implements Observer<EvaluableElement>, Runnable {

  private static final File AUDIO = new File("./res/audio/click.WAV");

  private Clip clip;

  @Override
  public void inform(EvaluableElement element) {
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
