package draw10AtStart.PlayGround;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class LoginFram extends JFrame {
    private ArrayList<JComponent> MainGUIComponent;
    private String name[];
    private int att[][];
    private JFrame nextFrame;

    public LoginFram() {
        int fill[] = { GridBagConstraints.BOTH, GridBagConstraints.VERTICAL, GridBagConstraints.HORIZONTAL,
                GridBagConstraints.NONE };
        int anchor[] = { GridBagConstraints.CENTER, GridBagConstraints.EAST, GridBagConstraints.SOUTHEAST,
                GridBagConstraints.SOUTH, GridBagConstraints.SOUTHWEST, GridBagConstraints.WEST,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH, GridBagConstraints.NORTHEAST };

        String n[] = { "UserName:", "Password:", "" };
        int a[][] = { { 0, 0, 1, 1, 0, 0, fill[3], anchor[5] }, { 0, 1, 1, 1, 0, 0, fill[3], anchor[5] },
                { 0, 2, 1, 1, 0, 0, fill[3], anchor[5] }, { 1, 0, 6, 1, 0, 0, fill[2], anchor[5] },
                { 1, 1, 6, 1, 0, 0, fill[2], anchor[5] }, { 0, 2, 1, 1, 0, 0, fill[0], anchor[0] } };

        att = a;
        name = n;
        MainGUIComponent = new ArrayList<JComponent>();
    }

    private void loginFramGenarate() {
        // f = initFrame(f, "login");
        /* setting Connection fram */
        setLayout(new GridBagLayout());
        /* setting Connection fram */

        /* add component to container */
        int i;
        for (i = 0; i < 3; i++) {
            JLabel nLabel = new JLabel(name[i]);
            MainGUIComponent.add(nLabel);
        }
        for (i = 0; i < 1; i++) {
            JTextField nUser = new JTextField("", 1);
            MainGUIComponent.add(nUser);
        }
        for (i = 0; i < 1; i++) {
            JTextField nPass = new JTextField("", 1);
            MainGUIComponent.add(nPass);
        }
        for (i = 0; i < 1; i++) {
            JButton nButton = new JButton("Login");
            MainGUIComponent.add(nButton);
        }
        for (i = 0; i < MainGUIComponent.size(); i++) {
            addComponent(i, MainGUIComponent, f);
        }
        /* add component to container */

        /* Add Listener */

        JButton b = (JButton) MainGUIComponent.get(5);
        b.addActionListener(new LoginListenner());

        /* Add Listener */
        /* show Jfram */
        setVisible(true);
        /* show Jfram */
    }

    class LoginListenner implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JTextField user = (JTextField) MainGUIComponent.get(3);
            JTextField pass = (JTextField) MainGUIComponent.get(4);
            user.setText("");
            pass.setText("");
            // playFrame.removeAll()
        }
    }
}
