package hanon.app.model.analyst.rhythm;

import hanon.app.model.music.EvaluableElement;
import hanon.app.model.util.ThreadedObserver;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Clicker extends ThreadedObserver<EvaluableElement> {
  private final File AUDIO = new File("./res/audio/click.WAV");
  private final Clip clip = getClip();

  private Clip getClip() {
    Clip clip = null;
    try {
      AudioInputStream inputStream = AudioSystem.getAudioInputStream(AUDIO);
      clip = AudioSystem.getClip();
      clip.open(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return clip;
  }

  @Override
  public void consume(EvaluableElement e) {
    if (e != null) {
      clip.setFramePosition(0);
      clip.start();
    } else {
      clip.setFramePosition(0);
      clip.start();
      stop();
    }
  }
}

