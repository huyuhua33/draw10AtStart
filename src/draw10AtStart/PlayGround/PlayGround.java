package draw10AtStart.PlayGround;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ClientServer.Client.SimpleClient;
import charater.Monster.Monster1;
import charater.Player.Player;
import charater.Player.pet;
import draw10AtStart.PlayGround.Connection.WaitingFrame;
import draw10AtStart.PlayGround.LoginFrame.LoginFrame;

public class PlayGround {
    private Frame playFrame;
    private int att[][];

    private Frame tmpFrame;
    private SimpleClient sc;
    
    private int w = 580;
    private int h = 570;

    public PlayGround() {

    }

    public void run() {
        playFrame = new LoginFrame(w, h);

        // waitingFramGenerate(playFrame);

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

    public void updateFrame(JFrame f, JPanel p, battleFild.Dialog d) {
        if (f.getComponentCount() > 1) {
            f.remove(f.getComponent(0));
            f.remove(f.getComponent(1));
        }
        f.add(p);
        f.add(d);
    }

    class battleFild {
        

            public void dialogUpdating(String words) {

                /*
                 * this.remove(this.getComponent(0)); if (this.getComponentCount() > 1) {
                 * this.remove(this.getComponent(1)); } JLabel bG = new JLabel();
                 * bG.setOpaque(false); bG.setIcon(dialogBack); bG.setBounds(0, 0, 570, 120);
                 * JLabel wD = new JLabel(words); wD.setBounds(50, 25, 570, 50);
                 * System.out.println(this.getName() + wD.getText()); this.add(wD);
                 * this.add(bG);
                 */
            }

        }

    }

    /*
     * class SelectionListener implements KeyListener { int get_Key; Dialog dialog;
     * 
     * SelectionListener(Dialog d) { dialog = d; }
     * 
     * @Override public void keyPressed(KeyEvent e) { get_Key = e.getKeyCode(); if
     * (get_Key == KeyEvent.VK_UP) { selection += 2; dialog.dialogUpdating("up");
     * System.out.println("up");
     * 
     * } if (get_Key == KeyEvent.VK_DOWN) { selection -= 2;
     * dialog.dialogUpdating("Down"); System.out.println("Down"); } if (get_Key ==
     * KeyEvent.VK_LEFT) { selection++; dialog.dialogUpdating("Left");
     * System.out.println("Left"); } if (get_Key == KeyEvent.VK_RIGHT) {
     * selection--; dialog.dialogUpdating("Right"); System.out.println("Right"); }
     * if (get_Key == KeyEvent.VK_ENTER) { dialog.dialogUpdating("Enter");// select
     * the function System.out.println("Enter"); } if (selection < 0) selection = 0;
     * 
     * updateFrame(playFrame, panJpanel, dialog); }
     * 
     * @Override public void keyReleased(KeyEvent e) { // TODO Auto-generated method
     * stub
     * 
     * }
     * 
     * @Override public void keyTyped(KeyEvent e) { // TODO Auto-generated method
     * stub
     * 
     * }
     * 
     * }
     */
}
