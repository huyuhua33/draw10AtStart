package draw10AtStart.PlayGround.Connection;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClientServer.Client.SimpleClient;
import charater.Player.Player;
import draw10AtStart.PlayGround.Frame;
import draw10AtStart.PlayGround.BattleFiled.BattleFiled;

public class WaitingFrame extends Frame {
    boolean connected = false;
    Thread n = null;
    private ArrayList<JComponent> WaitingGUIComponent = new ArrayList<JComponent>();
    private JPanel[] nPanels = { null, null };
    private SimpleClient sc;
    int[] location = { 100, 100, 200, 100 };
    private boolean start = false;

    public WaitingFrame(int x, int y, Player p) {
        super(x, y);
        setBackground(Color.RED);
        setLayout(new GridLayout(3, 1));
        String n[] = { "new", "NowWaiting..." };
        for (int i = 0; i < 2; i++) {
            JPanel np = new JPanel();
            GridLayout ly = new GridLayout(2, 1);
            np.setLayout(ly);
            // np.setBounds(location[0], location[1] * i, location[2], location[3]);
            nPanels[i] = np;
            for (int j = 0; j < 2; j++) {
                JLabel nLabel = new JLabel(n[j]);
                WaitingGUIComponent.add(nLabel);
                // nLabel.setBounds(75, 10 * j, 100, 20);
                np.add(nLabel);
            }
            add(np);
        }
        for (int i = 0; i < 1; i++) {
            JButton nButton = new JButton();
            nButton.addActionListener(new StartBtnListener());
            // nButton.setBounds(250, 400, 100, 100);
            WaitingGUIComponent.add(nButton);
        }

        ConnectionListener CL = new ConnectionListener("connect");
        JLabel[] user1 = { (JLabel) WaitingGUIComponent.get(0), (JLabel) WaitingGUIComponent.get(1) };
        JLabel[] user2 = { (JLabel) WaitingGUIComponent.get(0 + 2), (JLabel) WaitingGUIComponent.get(1 + 2) };
        user1[0].setText(p.getName());
        user1[1].setText("Connected");
        user2[0].setText("player 2");// from server
        setVisible(true);
    }

    /* connection listener */
    class StartBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            n.start();// send game start packge to socket
        }

    }

    class ConnectionListener implements Runnable {

        private ConnectionListener(String name) {
            sc = new SimpleClient();
            n = new Thread(this, name);
            n.start();

            // setting socket and connection
        }

        @Override
        public void run() {// need to rewrite
            /* simulating connection */
            try {
                System.out.println("Connecting");
                connected = sc.getConnected();
                while (!connected) {
                    // System.out.println("getting connection" + connected);
                    connected = sc.getConnected();
                }
                if (connected) {
                    System.out.println("Connected");
                    start = sc.gameStart();
                }
                if (start) {
                    frameChanging(new BattleFiled(WaitingFrame.super.getFrameSize_weith(),
                            WaitingFrame.super.getFrameSize_height(), sc));
                }

            } catch (Exception e) {
                System.err.println(e);
            }
            /* simulating connection */
        }

        public boolean isConnected() {
            return connected;
        }

        public void setConnected(boolean c) {
            connected = c;
        }

    }

}
