<<<<<<< HEAD
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
=======
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class tmp extends Canvas {
    public tmp() {

        setSize(600, 480);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 100, 50);
       
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyCanvasDemo_1");
        frame.setResizable(true);
        JPanel jp = new JPanel();
        //frame.getComponent().add()
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
>>>>>>> 0fd1403fa574305a05989c9525289373b41751d0
