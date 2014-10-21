package hanon.app.model.recorder;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;
import java.io.File;

public class FileRecording implements Recording {
  private TargetDataLine targetDataLine;

  @Override
  public void record(TargetDataLine targetDataLine) {
    this.targetDataLine = targetDataLine;
    new CaptureThread().start();
  }

  @Override
  public void setVolume(double volume) {
    
  }

  @Override
  public double getVolume() {
    return 0;
  }

  private class CaptureThread extends Thread {
    public void run() {
      AudioFileFormat.Type fileType =  AudioFileFormat.Type.WAVE;
      File audioFile = new File("junk.wav");

      try{
        AudioSystem.write(
                new AudioInputStream(targetDataLine),
                fileType,
                audioFile);
      }catch (Exception e){
        e.printStackTrace();
      }
    }
  }
}
