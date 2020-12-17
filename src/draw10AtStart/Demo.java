package draw10AtStart;
import javax.swing.SwingUtilities;

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
