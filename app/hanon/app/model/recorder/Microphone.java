package hanon.app.model.recorder;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.SilenceDetector;
import be.tarsos.dsp.io.jvm.JVMAudioInputStream;

import javax.sound.sampled.*;

import static be.tarsos.dsp.SilenceDetector.DEFAULT_SILENCE_THRESHOLD;

public class Microphone implements SoundDevice {

  private static final float SAMPLE_RATE = 8000.0f;

  private static final int SAMPLE_SIZE_BITS = 16;
  private static final int CHANNEL = 1;
  private static final boolean IS_SIGNED = true;
  private static final boolean IS_BIG_ENDIAN = false;
  private static final int BUFFER_SIZE = 512;
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
  private Recording recording;
  private final AudioDispatcher dispatcher;
  private final SilenceDetector volumeDetector =
          new SilenceDetector(DEFAULT_SILENCE_THRESHOLD, false);


  public Microphone() {
    targetDataLine = getDataLine();
    dispatcher = getDispatcher();
    new Thread(dispatcher).start();
  }

  private TargetDataLine getDataLine() {
    TargetDataLine line = null;
    try {
      line = (TargetDataLine) AudioSystem.getLine(DATA_LINE_INFO);
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
    return line;
  }

  private AudioDispatcher getDispatcher() {
    AudioInputStream inputStream = new AudioInputStream(targetDataLine);
    final JVMAudioInputStream audioStream = new JVMAudioInputStream(inputStream);
    AudioDispatcher dis = new AudioDispatcher(audioStream, BUFFER_SIZE, 0);
    dis.addAudioProcessor(volumeDetector);
    return dis;
  }

  public void startRecording(Recording recording){
    this.recording = recording;
    try {
      targetDataLine.open(DEFAULT_FORMAT, BUFFER_SIZE);
      targetDataLine.start();
      recording.record(targetDataLine);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Recording stopRecording() {
    targetDataLine.stop();
    targetDataLine.close();
    recording.setVolume(volumeDetector.currentSPL());
    return recording;
  }

  @Override
  public Recording getSound() {
    return recording;
  }
}