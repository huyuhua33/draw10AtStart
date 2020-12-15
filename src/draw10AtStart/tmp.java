import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.InputStream;

public class tmp extends JFrame implements KeyListener {
    final JLabel label1 = new JLabel("text1");

    public tmp() {
        initUI();
    }

    public final void initUI() {
        add(label1);

        addKeyListener(this);

        setTitle("Bla");
        setPreferredSize(new Dimension(400, 250));
        // setMinimumSize();
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void keyPressed(KeyEvent e) {
        if (label1.getText().compareTo("text1") == 0) {
            label1.setText("foo");
            System.out.println("foo");
        } else {
            label1.setText("text1");
            System.out.println("foo");
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tmp ex = new tmp();
                ex.setVisible(true);
            }
        });
    }
}
