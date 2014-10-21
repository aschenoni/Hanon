package hanon.app.model.recorder;

import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.Yin;

import javax.sound.sampled.TargetDataLine;

public class DataRecording implements Recording {

  private TargetDataLine targetDataLine;
  private byte[] byteArr;
  private double volume;


  public static void main(String args[]){
    DataRecording recording = new DataRecording();
    Microphone mic = new Microphone();
    mic.startRecording(recording);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    mic.stopRecording();
    float[] res = recording.getFloatArray();
    for(float f: res){
      System.out.print(f + " ");
    }
    System.out.println();

    Yin pitch = new Yin(8000, 1024);
    PitchDetectionResult pdr = pitch.getPitch(res);
    System.out.println(pdr.getPitch());
    System.out.println(pdr.getProbability());

    mic.stopRecording();
  }

  @Override
  public void record(TargetDataLine targetDataLine) {
    this.targetDataLine = targetDataLine;
    new CaptureThread().start();
  }

  @Override
  public void setVolume(double volume) {
    this.volume = volume;
  }

  @Override
  public double getVolume() {
    return volume;
  }

  private class CaptureThread extends Thread{

    public CaptureThread() {
      super();
      setDaemon(true);
    }

    public void run(){
      byteArr = new byte[2048];
      targetDataLine.read(byteArr, 0, 2048);
    }
  }

  public byte[] getByteArray() {
    return byteArr;
  }

  public float[] getFloatArray(){
    float[] floatArr = new float[byteArr.length/2];
    for (int i=0; i<byteArr.length; i+=2){
      floatArr[i/2] = bytesToFloat(byteArr[i], byteArr[i+1]);
    }
    return floatArr;
  }

  float bytesToFloat(byte b0, byte b1){
    return (float) ((double)((b1 << 8)|(b0 & 0xFF))/32767.0);
  }
}
