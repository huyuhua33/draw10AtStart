package draw10AtStart.PlayGround.BattleFiled;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import charater.Monster.Monster1;
import charater.Player.Player;
import charater.Player.pet;

public class Battfild {
    private String[] n = { "ATk[1]", "BAG[2]", "PET[3]", "RUN[4]" };
    private String sourceWay = new String("..\\..\\sprit\\");
    private String[] filesPath = { "battle_background.jpg", "battle_background.jpg", "hp0_right.jpg", "hp0_left.jpg",
            "dialog.jpg" };
    private int[][] dirction = { { 400, 50, 100, 100 }, { 50, 200, 100, 100 }, { 300, 210, 230, 100 },
            { 50, 30, 230, 100 } };

    private String[] hpBar = { "full-hp.jpg", "half-hp.jpg", "non-hp.jpg" };
    private int[][] hpBarDirction = { { dirction[2][0] + 65, dirction[2][1] + 47, 99, 4 },
            { dirction[3][1] + 65, dirction[3][1] + 47, 99, 4 } };
    private String[] petsName = { "Pet1", "Pet2" };
    private int[][] petsDirction = { { dirction[2][0] + 57, dirction[2][1] + 27 },
            { dirction[3][1] + 55, dirction[3][1] + 27 } };

    private ArrayList<JLabel> lArrayList;
    private JLabel[] hpBars = { null, null };
    private pet[] battlePets = { null, null };

    private int att[][];
    private Dialog ddialog;
    private Player player;

    public Battfild(JFrame f) {
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
        // f.add(btf);

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
}
