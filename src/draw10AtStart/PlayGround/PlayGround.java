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
    private String name[];
    private int att[][];

    private Frame tmpFrame;

    private battleFild.Dialog ddialog;
    private JPanel panJpanel;
    private JLabel[] hpBars = { null, null };
    private Player player;

    private SimpleClient sc;
    private pet[] battlePets = { null, null };
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
        String[] n = { "ATk[1]", "BAG[2]", "PET[3]", "RUN[4]" };
        String sourceWay = new String("..\\..\\sprit\\");
        String[] filesPath = { "battle_background.jpg", "battle_background.jpg", "hp0_right.jpg", "hp0_left.jpg",
                "dialog.jpg" };
        int[][] dirction = { { 400, 50, 100, 100 }, { 50, 200, 100, 100 }, { 300, 210, 230, 100 },
                { 50, 30, 230, 100 } };

        String[] hpBar = { "full-hp.jpg", "half-hp.jpg", "non-hp.jpg" };
        int[][] hpBarDirction = { { dirction[2][0] + 65, dirction[2][1] + 47, 99, 4 },
                { dirction[3][1] + 65, dirction[3][1] + 47, 99, 4 } };

        String[] petsName = { "Pet1", "Pet2" };
        int[][] petsDirction = { { dirction[2][0] + 57, dirction[2][1] + 27 },
                { dirction[3][1] + 55, dirction[3][1] + 27 } };

        ArrayList<JLabel> lArrayList;

        public battleFild(JFrame f) {
            battlePets[0] = (pet) new Monster1("AA", 50, 10, 10, 10, 10);
            lArrayList = new ArrayList<JLabel>();
            f.setLayout(null);
            // ArrayList<JComponent> battleFildGUIComponent = new ArrayList<JComponent>();
            JPanel pann = new JPanel();
            pann.setLayout(null);
            pann.setBounds(0, 0, f.getWidth(), f.getHeight() - 200);
            att = hpBarDirction;
            for (int i = 0; i < 2; i++) {
                JLabel nJLabel = new JLabel(petsName[i]);
                nJLabel.setBounds(petsDirction[i][0], petsDirction[i][1], 100, 20);
                pann.add(nJLabel);
            }
            for (int i = 0; i < 2; i++) {
                ImageIcon im = new ImageIcon(sourceWay + hpBar[0]);
                JLabel jb = new JLabel();
                jb.setIcon(im);
                jb.setBounds(hpBarDirction[i][0], hpBarDirction[i][1], hpBarDirction[i][2], hpBarDirction[i][3]);
                hpBars[i] = jb;
                pann.add(jb);
            }
            for (int i = 0; i < 4; i++) {
                ImageIcon im = new ImageIcon(sourceWay + filesPath[i]);
                JLabel jb = new JLabel();
                jb.setIcon(im);
                if (i > 1)
                    jb.setOpaque(false);
                jb.setBounds(dirction[i][0], dirction[i][1], dirction[i][2], dirction[i][3]);
                pann.add(jb);
            }
            JLabel dLabel = new JLabel("Dialog");
            dLabel.setBounds(50, 320, 100, 20);
            lArrayList.add(dLabel);
            pann.add(dLabel);

            /* setting dialog words */
            Dialog dialogPanel = new Dialog(sourceWay + filesPath[4]);
            dialogPanel.setBounds(0, f.getHeight() - 200, f.getWidth(), 120);
            String testWords = new String("this is test words");
            dialogPanel.dialogUpdating(testWords);
            dialogPanel.dialogUpdating("dddd");
            // f.add(btf);
            ddialog = dialogPanel;
            panJpanel = pann;
            PlayGround.this.updateFrame(f, panJpanel, ddialog);

            battlePets[0] = player.getPets().get(0);

            f.setVisible(true);

        }

        class bListener1 implements ActionListener {
            JPanel pann;

            public bListener1(JPanel pan) {
                pann = pan;
            }

            public bListener1() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int w = hpBars[0].getWidth() - 10;
                if (w < 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                    hpBars[0].remove(hpBars[0]);
                    hpBars[0].setIcon(n);
                }
                if (w > 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[0]);
                    hpBars[0].remove(hpBars[0]);
                    hpBars[0].setIcon(n);
                }
                if (w < 20) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[2]);
                    hpBars[0].remove(hpBars[0]);
                    hpBars[0].setIcon(n);
                }
                if (w <= 0)
                    w = 0;
                hpBars[0].setBounds(hpBars[0].getX(), hpBars[0].getY(), w, hpBars[0].getHeight());// TODO Auto-generate
                // /
                System.out.println("btnClick");

                lArrayList.get(1).setText("btn1 clicked");
                lArrayList.get(0).setText("btn1 clicked");
                ;
            }
        }

        class bListener2 implements ActionListener {
            JPanel pann;

            public bListener2(JPanel pan) {
                pann = pan;
            }

            public bListener2() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int w = hpBars[1].getWidth() - 10;
                if (w < 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                    hpBars[1].remove(hpBars[1]);
                    hpBars[1].setIcon(n);
                }
                if (w > 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                    hpBars[1].remove(hpBars[0]);
                    hpBars[1].setIcon(n);
                }
                if (w < 20) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[2]);
                    hpBars[1].remove(hpBars[1]);
                    hpBars[1].setIcon(n);
                }
                if (w <= 0)
                    w = 0;
                hpBars[1].setBounds(hpBars[1].getX(), hpBars[1].getY(), w, hpBars[1].getHeight());// TODO Auto-generate

                lArrayList.get(2).setText("btn2 clicked");
                lArrayList.get(0).setText("btn2 clicked");
            }
        }

        class bListener3 implements ActionListener {
            JPanel pann;

            public bListener3(JPanel pan) {
                pann = pan;
            }

            public bListener3() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int w = hpBars[1].getWidth() + 10;
                if (w < 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                    hpBars[1].remove(hpBars[1]);
                    hpBars[1].setIcon(n);
                }
                if (w > 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[0]);
                    hpBars[1].remove(hpBars[1]);
                    hpBars[1].setIcon(n);
                }
                if (w < 20) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[2]);
                    hpBars[1].remove(hpBars[1]);
                    hpBars[1].setIcon(n);
                }
                if (w <= 0)
                    w = 0;
                hpBars[1].setBounds(hpBars[1].getX(), hpBars[1].getY(), w, hpBars[1].getHeight());// TODO Auto-generate

                lArrayList.get(3).setText("btn3 clicked");
                lArrayList.get(0).setText("btn3 clicked");
            }
        }

        class bListener4 implements ActionListener {
            JPanel pann;

            public bListener4(JPanel pan) {
                pann = pan;
            }

            public bListener4() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int w = hpBars[0].getWidth() + 10;
                if (w < 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                    hpBars[0].remove(hpBars[0]);
                    hpBars[0].setIcon(n);
                }
                if (w > 50) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[0]);
                    hpBars[0].remove(hpBars[0]);
                    hpBars[0].setIcon(n);
                }
                if (w < 20) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[2]);
                    hpBars[0].remove(hpBars[0]);
                    hpBars[0].setIcon(n);
                }
                if (w <= 0)
                    w = 0;
                hpBars[0].setBounds(hpBars[0].getX(), hpBars[0].getY(), w, hpBars[0].getHeight());// TODO Auto-generate
                // /
                lArrayList.get(4).setText("btn4 clicked");
                lArrayList.get(0).setText("btn4 clicked");
            }
        }

        class Dialog extends JPanel {
            private ImageIcon dialogBack;
            private JPanel selectionPanel;
            int i = 0;
            String[] n = { "ATk[1]", "BAG[2]", "PET[3]", "RUN[4]" };
            int x = 50, y = 0;
            int[][] dic = { { x, y }, { x + 143, y + 0 }, { x, y + 60 }, { x + 143, y + 60 } };

            Dialog(String fileLocate) {
                setLayout(null);
                setName("name");
                dialogBack = new ImageIcon(fileLocate);
                // JLabel bG = new JLabel();
                // bG.setOpaque(false);
                // bG.setIcon(dialogBack);
                // bG.setBounds(0, 0, 570, 120);
                int i = 0;
                JButton nButton = new JButton(n[i]);
                nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
                nButton.addActionListener(new bListener1());
                add(nButton);

                i = 1;
                nButton = new JButton(n[i]);
                nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
                nButton.addActionListener(new bListener2());
                add(nButton);

                i = 2;
                nButton = new JButton(n[i]);
                nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
                nButton.addActionListener(new bListener3());
                add(nButton);

                i = 3;
                nButton = new JButton(n[i]);
                nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
                nButton.addActionListener(new bListener4());
                add(nButton);

                for (i = 0; i < 4; i++) {
                    JLabel wordDialog = new JLabel(battlePets[0].skillList.get(i).getSkillName());
                    wordDialog.setBounds(dic[i][0] + (i % 2 == 0 ? 300 : 280), dic[i][1], 100, 20);
                    add(wordDialog);
                    lArrayList.add(wordDialog);
                }

                // this.add(bG);

            }

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
