//package draw10AtStart;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;

import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
    private int selection = 0;

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
        battleFild(playFrame);

    }

    private void initFrame(JFrame f) {
        f.setSize(570, 450);
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

    class Dialog extends JPanel {
        ImageIcon dialogBack;

        Dialog(String fileLocate) {
            dialogBack = new ImageIcon(fileLocate);
            JLabel bG = new JLabel();
            bG.setOpaque(false);
            bG.setIcon(dialogBack);
            this.add(bG);
        }

        public void dialogUpdating(String words) {
            JLabel bG = new JLabel();
            bG.setOpaque(false);
            bG.setIcon(dialogBack);
            JLabel wD = new JLabel(words);
            this.add(wD);
            this.add(bG);

        }
    }

    public void battleFild(JFrame f) {
        f.setLayout(null);
        String[] n = { "ATk[1]", "BAG[2]", "PET[3]", "RUN[4]" };
        String sourceWay = new String("..\\..\\sprit\\");
        String[] filesPath = { "battle_background.jpg", "battle_background.jpg", "hp0_right.jpg", "hp0_left.jpg",
                "dialog.jpg" };

        int[][] dirction = { { 400, 50, 100, 100 }, { 50, 200, 100, 100 }, { 300, 210, 230, 100 },
                { 50, 30, 230, 100 } };
        ArrayList<JComponent> battleFildGUIComponent = new ArrayList<JComponent>();
        // battleFildCanves btf = new battleFildCanves();
        JPanel pann = new JPanel();
        pann.setLayout(null);
        pann.setBounds(0, 0, f.getWidth(), f.getHeight() - 200);
        for (int i = 0; i < 4; i++) {
            ImageIcon im = new ImageIcon(sourceWay + filesPath[i]);
            JLabel jb = new JLabel();
            jb.setIcon(im);
            jb.setBounds(dirction[i][0], dirction[i][1], dirction[i][2], dirction[i][3]);
            pann.add(jb);
        }
        Dialog dialogPanel = new Dialog(sourceWay + filesPath[4]);
        dialogPanel.setBounds(0, f.getHeight() - 200, f.getWidth(), f.getHeight());

        /* setting dialog */
        /*
         * GridLayout ly = new GridLayout(2, 2, 1, 1); pann.setLayout(ly); for (int i =
         * 0; i < 4; i++) { JLabel nLabel = new JLabel(n[i]);
         * battleFildGUIComponent.add(nLabel); pann.add(nLabel,i,i%2); }
         */
        /* setting btn */

        /* setting canves */

        /* setting canves */
        // f.add(btf);
        f.add(pann);
        f.add(dialogPanel);
        f.setVisible(true);

    }

    class battleFildCanves extends JPanel {
        Image img;

        battleFildCanves() {
        }

        public void drawBattleFild() {

        }

        public void battleFildUpdate() {

        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon img = new ImageIcon("dialog.bmp");
            g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        }

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

    class SelectionListener implements KeyListener {
        int get_Key;

        @Override
        public void keyPressed(KeyEvent e) {

            get_Key = e.getKeyCode();
            if (get_Key == KeyEvent.VK_UP) {
                selection += 2;
            }
            if (get_Key == KeyEvent.VK_DOWN) {
                selection -= 2;
            }
            if (get_Key == KeyEvent.VK_LEFT) {
                selection++;
            }
            if (get_Key == KeyEvent.VK_RIGHT) {
                selection--;
            }
            if (get_Key == KeyEvent.VK_ENTER)
                ;
            {
                // select the function
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

}
