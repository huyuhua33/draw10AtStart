package draw10AtStart.PlayGround;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import charater.Player.Player;
import draw10AtStart.Frame;

public class LoginFram extends Frame {
    private ArrayList<JComponent> GUIComponent;
    private String name[];
    private int att[][];

    protected Player nUser;

    public LoginFram(int w, int h,) {
        super(w, h);
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
        GUIComponent = new ArrayList<JComponent>();

        setLayout(new GridBagLayout());
        /* setting Connection fram */

        /* add component to container */
        int i;
        for (i = 0; i < 3; i++) {
            JLabel nLabel = new JLabel(name[i]);
            GUIComponent.add(nLabel);
        }
        for (i = 0; i < 1; i++) {
            JTextField nUser = new JTextField("", 1);
            GUIComponent.add(nUser);
        }
        for (i = 0; i < 1; i++) {
            JTextField nPass = new JTextField("", 1);
            GUIComponent.add(nPass);
        }
        for (i = 0; i < 1; i++) {
            JButton nButton = new JButton("Login");
            GUIComponent.add(nButton);
        }
        for (i = 0; i < GUIComponent.size(); i++) {
            addComponent(i, GUIComponent, this);
        }
        /* add component to container */

        /* Add Listener */

        JButton b = (JButton) GUIComponent.get(5);
        b.addActionListener(new LoginListenner());

        /* Add Listener */
        /* show Jfram */
        setVisible(true);
    }

    private void addComponent(int i, ArrayList<JComponent> List, JFrame f) {
        GridBagConstraints c = new GridBagConstraints();
        int a[] = att[i];
        c.gridx = a[0];
        c.gridy = a[1];
        c.gridwidth = a[2];
        c.gridheight = a[3];
        c.weightx = a[4];
        c.weighty = a[5];
        c.fill = a[6];
        c.anchor = a[7];
        f.add(List.get(i), c);
    }

    class LoginListenner implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JTextField user = (JTextField) GUIComponent.get(3);
            JTextField pass = (JTextField) GUIComponent.get(4);
            nUser = new Player(user.getText(), pass.getText());
            user.setText("");
            pass.setText("");
            // playFrame.removeAll()
        }
    }

    @Override
    public void frameUpdate() {
        super.frameUpdate();// TODO Auto-generated method stub
    }

    @Override
    public Frame frameChanging() {

    }

    public Player getnUser() {
        return nUser;
    }

    public void setnUser(Player nUser) {
        this.nUser = nUser;
    }
}
