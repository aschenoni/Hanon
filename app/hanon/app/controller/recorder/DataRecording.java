package hanon.app.controller.recorder;

import javax.sound.sampled.TargetDataLine;

public class DataRecording implements Recording {

  private TargetDataLine targetDataLine;
  private byte[] arr;

  public static void main(String args[]){
    DataRecording recording = new DataRecording();
    Microphone mic = new Microphone(recording);
    mic.startRecord();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    mic.stopRecording();
    byte[] res = recording.generateByteArray();
    for(byte b: res){
      System.out.print(b + " ");
    }
    mic.closeRecording();
  }

  @Override
  public void record(TargetDataLine targetDataLine) {
    this.targetDataLine = targetDataLine;
    new CaptureThread().start();
  }

  private class CaptureThread extends Thread{

    public void run(){
      arr = new byte[100000];
      targetDataLine.read(arr, 0, 100000);
    }

  }

  public byte[] generateByteArray() {
    return arr;
  }
}
