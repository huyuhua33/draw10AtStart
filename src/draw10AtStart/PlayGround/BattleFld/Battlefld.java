package draw10AtStart.PlayGround.BattleFld;

import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ClientServer.Data_frame;
import ClientServer.Client.SimpleClient;
import charater.skill;
import charater.Player.pet;
import draw10AtStart.PlayGround.Frame;

public class Battlefld extends Frame {
    /* controling var */
    /* frame control */
    private ArrayList<JLabel> dialogList;
    private ArrayList<JLabel> petUIList;
    private String sendData;

    /* frame control */
    /* action control */
    private Data_frame[] action = { null, null };
    private pet[] battlePets = { null, null };

    // private SimpleClient sClient;
    /* action control */
    /* controling var */

    /* UI setting source */
    /* monster and hpbar */
    private String sourceWay = new String("sprit");
    private String[] filesPath = { "\\monster\\battle_background.jpg", "\\monster\\battle_background.jpg",
            "\\healthBar\\hp0_right.jpg", "\\healthBar\\hp0_left.jpg", "\\dialog\\dialog.jpg" };
    private int[][] dirction = { { 400, 50, 100, 100 }, { 50, 200, 100, 100 }, { 300, 210, 230, 100 },
            { 50, 30, 230, 100 } };
    /* monster and hpbar */
    /* hp */
    private String[] hpBar = { "\\healthBar\\full-hp.jpg", "\\healthBar\\half-hp.jpg", "\\healthBar\\non-hp.jpg" };
    private int[][] hpBarDirction = { { dirction[2][0] + 65, dirction[2][1] + 47, 99, 4 },
            { dirction[3][1] + 65, dirction[3][1] + 47, 99, 4 } };
    /* hp */
    /* pet label */
    private String[] petsName = { "Pet1", "Pet2" };
    private int[][] petsDirction = { { dirction[2][0] + 57, dirction[2][1] + 27 },
            { dirction[3][1] + 55, dirction[3][1] + 27 } };

    /* pet label */
    /* UI setting source */
    public Battlefld(int w, int h, SimpleClient c) {
        super(w, h);

    }

    class connectionListener implements Runnable {
        SimpleClient sClient;

        /* only try to get data */
        connectionListener(SimpleClient n) {
            Thread t = new Thread(this);
            sClient = n;
            t.start();
        }

        public void run() {
            while (true) {

                try {
                    action[1] = sClient.getDatf();

                } catch (Exception e) {

                }
            }
        }
    }

    class gameRule implements Runnable {
        Data_frame nowAct;

        public gameRule() {
            Thread t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            while (true) {
                if (action[0] != null && action[1] != null) {
                    nowAct = action[0].getSpeed() > action[1].getSpeed() ? action[0] : action[1];

                }
            }

        }

    }

    class UIListener {
        skill[] skillList;

        UIListener() {
            skillList = new skill[4];
            update_skill();
        }

        void update_skill() {
            for (int i = 0; i < 4; i++) {
                skillList[i] = battlePets[0].getSkillList().get(i);
                dialogList.get(i + 1).setText(skillList[i].getSkillName());
            }
        }

        // only send data
        private class bListener1 implements ActionListener {
            private int i = 0;

            public bListener1() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // do the action and send to sever
                sendData = String.valueOf(battlePets[0].getLife()) + "/" + String.valueOf(battlePets[0].getSpeed())
                        + "/" + battlePets[0].getName() + "/" + skillList[i].getSkillType() + "/"
                        + String.valueOf(skillList[i].getSkillPow()) + "/" + skillList[i].getSkillName() + "/"
                        + battlePets[0].getDefend();

                // nClient.battleFildDataTransform(sendData);
                action[0] = new Data_frame(sendData);
                // lArrayList.get(1).setText("btn1 clicked");
                // lArrayList.get(0).setText("btn1 clicked");
            }
        }

        class bListener2 implements ActionListener {
            int i = 1;

            public bListener2() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                sendData = String.valueOf(battlePets[0].getLife()) + "/" + String.valueOf(battlePets[0].getSpeed())
                        + "/" + battlePets[0].getName() + "/" + skillList[i].getSkillType() + "/"
                        + String.valueOf(skillList[i].getSkillPow()) + "/" + skillList[i].getSkillName() + "/"
                        + battlePets[0].getDefend();
                action[0] = new Data_frame(sendData);
                // nClient.battleFildDataTransform(sendData);
                System.out.println(sendData);
                // lArrayList.get(2).setText("btn2 clicked");
                // lArrayList.get(0).setText("btn2 clicked");
            }
        }

        class bListener3 implements ActionListener {
            int i = 2;

            public bListener3() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                sendData = String.valueOf(battlePets[0].getLife()) + "/" + String.valueOf(battlePets[0].getSpeed())
                        + "/" + battlePets[0].getName() + "/" + skillList[i].getSkillType() + "/"
                        + String.valueOf(skillList[i].getSkillPow()) + "/" + skillList[i].getSkillName() + "/"
                        + battlePets[0].getDefend();
                // nClient.battleFildDataTransform(sendData);
                action[0] = new Data_frame(sendData);
                System.out.println(sendData);
                // lArrayList.get(3).setText("btn3 clicked");
                // lArrayList.get(0).setText("btn3 clicked");
            }
        }

        class bListener4 implements ActionListener {
            int i = 3;

            public bListener4() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                sendData = String.valueOf(battlePets[0].getLife()) + "/" + String.valueOf(battlePets[0].getSpeed())
                        + "/" + battlePets[0].getName() + "/" + skillList[i].getSkillType() + "/"
                        + String.valueOf(skillList[i].getSkillPow()) + "/" + skillList[i].getSkillName() + "/"
                        + battlePets[0].getDefend();
                action[0] = new Data_frame(sendData);
                System.out.println(sendData);
                // nClient.battleFildDataTransform(sendData);

                // lArrayList.get(4).setText("btn4 clicked");
                // lArrayList.get(0).setText("btn4 clicked");
            }
        }

    }

    class UIupdate implements Runnable {
        public UIupdate() {
            Thread t = new Thread(this);
            t.start();
        }

        void hpUpdate() {
            for (int i = 0; i < 2; i++) {
                if ((battlePets[i].getLife_MAX() * 0.3) < battlePets[i].getLife()
                        && battlePets[i].getLife() < (battlePets[i].getLife_MAX() * 0.5)) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                    petUIList.get(i).setIcon(n);
                }
                if (battlePets[i].getLife() > (battlePets[i].getLife_MAX() * 0.5)) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[0]);
                    petUIList.get(i).setIcon(n);
                }
                if (battlePets[i].getLife() < (battlePets[i].getLife_MAX() * 0.3)) {
                    ImageIcon n = new ImageIcon(sourceWay + hpBar[2]);
                    petUIList.get(i).setIcon(n);
                }
                int n = (int) Math
                        .round((battlePets[i].getLife() / battlePets[i].getLife_MAX()) * petUIList.get(i).getWidth());
                System.out.println(">>" + n);
                petUIList.get(i).setBounds(petUIList.get(i).getX(), petUIList.get(i).getY(), n,
                        petUIList.get(i).getHeight());// TODO //

            }

        }

        void nameUpdate() {
            petUIList.get(2).setText(battlePets[0].getName());
            petUIList.get(3).setText(battlePets[1].getName());
            petUIList.get(4).setText(String.valueOf(battlePets[0].getDefend()));
            petUIList.get(5).setText(String.valueOf(battlePets[1].getDefend()));
        }

        @Override
        public void run() {
            while (true) {
                try {
                    hpUpdate();
                    nameUpdate();
                    Thread.sleep(200);
                } catch (Exception e) {
                    System.err.println("UIupdate + " + e);
                }
            }
            // TODO Auto-generated method stub

        }
    }
}
