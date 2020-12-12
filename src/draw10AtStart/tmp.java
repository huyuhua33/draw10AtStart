import java.awt.*;
import java.awt.event.*;

public class tmp extends Canvas {
    public tmp() {

        setSize(100, 100);
    }

    public void paint(Graphics g) {

        g.drawLine(-1, 0, 640, 480);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("MyCanvasDemo_1");
        frame.setResizable(true);

        frame.add(new tmp());
        frame.setSize(500, 500);
        frame.setLocation(100, 100);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
