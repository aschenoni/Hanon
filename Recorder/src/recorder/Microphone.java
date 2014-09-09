package recorder;

import javax.sound.sampled.*;

public class Microphone implements SoundDevice {

  public static void main(String [] args) {
    Microphone mic = new Microphone(new FileRecording());
    mic.startRecord();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    mic.stopRecording();
  }

  private static final float SAMPLE_RATE = 8000.0f;

  private static final int SAMPLE_SIZE_BITS = 16;
  private static final int CHANNEL = 1;
  private static final boolean IS_SIGNED = true;
  private static final boolean IS_BIG_ENDIAN = false;
  private static final AudioFormat DEFAULT_FORMAT =
          new AudioFormat(
                  SAMPLE_RATE,
                  SAMPLE_SIZE_BITS,
                  CHANNEL,
                  IS_SIGNED,
                  IS_BIG_ENDIAN);
  private static final DataLine.Info DATA_LINE_INFO =
          new DataLine.Info(TargetDataLine.class, DEFAULT_FORMAT);


  private TargetDataLine targetDataLine;
  private final Recording recording;

  private Microphone(Recording recording) {
    this.recording = recording;
    try {
      targetDataLine = (TargetDataLine) AudioSystem.getLine(DATA_LINE_INFO);
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
  }

  void startRecord(){
    // Capture input data from the microphone
    try {
      targetDataLine.open(DEFAULT_FORMAT);
      targetDataLine.start();
      recording.record(targetDataLine);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  void stopRecording() {
    targetDataLine.stop();
    targetDataLine.close();
  }

  @Override
  public Recording getSound() {
    return recording;
  }


}