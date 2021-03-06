package hanon.app.model.recorder;

import javax.sound.sampled.TargetDataLine;

public interface Recording {

  void record(TargetDataLine targetDataLine);

  void setVolume(double volume);

  double getVolume();
}
