package draw10AtStart;

import javax.swing.SwingUtilities;

import draw10AtStart.PlayGround.PlayGround;

public class Demo {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        PlayGround p = new PlayGround();
        p.run();
      }
    });

  }
}
