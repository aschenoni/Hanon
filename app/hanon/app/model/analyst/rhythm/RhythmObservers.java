package hanon.app.model.analyst.rhythm;

import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.music.EvaluableElement;
import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;
import hanon.app.model.util.ThreadedObserver;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class RhythmObservers {
  private static final TimedRecorder recorder = new TimedRecorder(350, new Microphone());
  public static final ThreadedObserver<EvaluableElement> pitchEvaluator =
          new ThreadedObserver<>(info -> {
                MusicNote toEmulate = (MusicNote)info;
                DataRecording rec = recorder.record();
                MusicNote played = MusicNote.fromSoundArr(rec.getFloatArray());

                System.out.println("Emulated Frequency");
                System.out.println(toEmulate.getFrequency());
                System.out.println("Played Frequency");
                System.out.println(played.getFrequency());
                System.out.println(played.getFrequencyOffset(toEmulate));
          });


  private static final File AUDIO = new File("./res/audio/click.WAV");
  private static final Clip clip = getClip();
  private static Clip getClip() {
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
  public static final ThreadedObserver<EvaluableElement> clicker =
          new ThreadedObserver<>(info -> {
            clip.setFramePosition(0);
            clip.start();
          });
}
