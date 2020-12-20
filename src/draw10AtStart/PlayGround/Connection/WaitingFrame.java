package draw10AtStart.PlayGround.Connection;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import charater.Player.Player;
import draw10AtStart.PlayGround.Frame;

public class WaitingFrame extends Frame implements Runnable {
    private ArrayList<JComponent> WaitingGUIComponent;

    public WaitingFrame(int x, int y, Frame nextFrame, Player player) {
        super(x, y, nextFrame);
        GridBagLayout ly = new GridBagLayout();
        setBackground(Color.RED);
        setLayout(null);
        String n[] = { player.getName(), "NowWaiting..." };
        for (int i = 0; i < 2; i++) {
            JLabel nLabel = new JLabel(n[i]);
            WaitingGUIComponent.add(nLabel);
        }

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
            // f.setBackground(Color.RED);
            nLabel.setText("Connected");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.err.println(e);
            }

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
        public void run() {// need to rewrite
            /* simulating connection */
            try {
                System.out.println("Connecting");
                connected = true;
                while (!connected) {
                    System.out.println("getting connection" + connected);
                    connected = sc.getConnected();
                }
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

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}
