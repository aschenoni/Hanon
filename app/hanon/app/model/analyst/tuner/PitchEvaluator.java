package hanon.app.model.analyst.tuner;

import hanon.app.model.analyst.Observer;
import hanon.app.model.analyst.TimedRecorder;
import hanon.app.model.music.EvaluableElement;
import hanon.app.model.music.MusicNote;
import hanon.app.model.recorder.DataRecording;
import hanon.app.model.recorder.Microphone;

public class PitchEvaluator implements Observer<EvaluableElement> {
  private final TimedRecorder recorder = new TimedRecorder(100, new Microphone());

  @Override
  public void inform(EvaluableElement info) {
    MusicNote toEmulate = (MusicNote)info;
    DataRecording rec = recorder.record();
    MusicNote played = MusicNote.fromSoundArr(rec.getFloatArray());
    
    System.out.println("Emulated Frequency");
    System.out.println(toEmulate.getFrequency());
    System.out.println("Played Frequency");
    System.out.println(played.getFrequency());
    //System.out.println(played.getFrequencyOffset());
  }
}
