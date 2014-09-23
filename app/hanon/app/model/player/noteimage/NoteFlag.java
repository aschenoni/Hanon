package hanon.app.model.player.noteimage;

import hanon.app.model.player.staff.Staff;

abstract class NoteFlag implements NoteComponent {

  public static NoteFlag fromPosition(int x, int y, int staffY) {
    if (y < staffY + 2* Staff.LINE_GAP)
      return new DownNoteFlag(x, y);
    else
      return new UpNoteFlag(x, y);
  }

}
