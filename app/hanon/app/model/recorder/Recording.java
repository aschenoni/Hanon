package hanon.app.model.recorder;

import javax.sound.sampled.TargetDataLine;

public interface Recording {

  void record(TargetDataLine targetDataLine);
}
