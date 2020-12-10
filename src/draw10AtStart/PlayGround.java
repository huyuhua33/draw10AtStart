//package draw10AtStart;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

import javax.swing.event.*;
import java.awt.event.*;
import java.sql.Connection;

public class PlayGround {
    private JFrame playFrame;
    private String name[];
    private int att[][];
    private ArrayList<JComponent> MainGUIComponent;
    private ArrayList<JComponent> WaitingGUIComponent;
    private Player player;

    private JFrame waitingFrame;
    private Boolean debug = true;

    public PlayGround() {
        if (debug)
            player = new Player("Name", "123");
        playFrame = new JFrame();
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
        WaitingGUIComponent = new ArrayList<JComponent>();
    }

    public void run() {
        initFrame(playFrame);
        // loginFramGenarate(playFrame);
        // waitingFramGenerate(playFrame);

    }

    private void initFrame(JFrame f) {
        f.setSize(600, 600);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loginFramGenarate(JFrame f) {
        /* setting Connection fram */
        f.setLayout(new GridBagLayout());
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
        f.setVisible(true);
        /* show Jfram */

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
            JTextField user = (JTextField) MainGUIComponent.get(3);
            JTextField pass = (JTextField) MainGUIComponent.get(4);

            player = new Player(user.getText(), pass.getText());
            user.setText("");
            pass.setText("");
            System.out.println("Log Ac: " + player);
            // System.out.println("equ " + player == new Player());
        }
    }

    private void waitingFramGenerate(JFrame f) {

        GridBagLayout ly = new GridBagLayout();
        f.setLayout(ly);
        String n[] = { player.getName(), "NowWaiting..." };
        int a[][] = { { 0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST },
                { 0, 1, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST } };
        for (int i = 0; i < 2; i++) {
            JLabel nLabel = new JLabel(n[i]);
            WaitingGUIComponent.add(nLabel);
        }
        for (int i = 0; i < WaitingGUIComponent.size(); i++) {
            addComponent(i, WaitingGUIComponent, f);
        }
        f.setVisible(true);
        ConnectionListener CL = new ConnectionListener("connect");
        while (!CL.isConnected()) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.err.print(e);
                // TODO: handle exception
            }

            // System.out.println("wait for connecting");

        }
        if (CL.isConnected()) {
            JLabel nLabel = (JLabel) WaitingGUIComponent.get(1);
            nLabel.setText("Connected");
        }

    }

    public void battleFild(JFrame f) {
        JPanel pann = new JPanel();

        f.getContentPane().add(pann);

    }

    /* connection listener */
    class ConnectionListener implements Runnable {
        boolean connected = false;
        Thread n = null;

        private ConnectionListener(String name) {
            n = new Thread(this, name);
            n.start();
            // setting socket and connection
        }

        @Override
        public void run() {
            /* simulating connection */
            try {
                Thread.sleep(2000);
                System.out.println("Connect");
                connected = true;
            } catch (Exception e) {
                System.err.println(e);
            }
            /* simulating connection */
        }

        public boolean isConnected() {
            return connected;
        }

        public void setConnected(boolean connected) {
            this.connected = connected;
        }

    }

}
