package draw10AtStart.PlayGround.BattleFld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ClientServer.Data_frame;
import ClientServer.Client.SimpleClient;
import charater.skill;
import charater.Monster.Monster1;
import charater.Monster.Monster1copy;
import charater.Monster.Monster1copy2;
import charater.Monster.Monster1copy3;
import charater.Monster.Monster1copy4;
import charater.Monster.Monster1copy5;
import charater.Monster.Monster1copycat;
import charater.Player.Player;
import charater.Player.pet;
import draw10AtStart.PlayGround.Frame;

public class Battlefld extends Frame {
    /* controling var */
    /* frame control */
    private static ArrayList<JLabel> dialogList = new ArrayList<JLabel>();
    private static ArrayList<JLabel> petUIList = new ArrayList<JLabel>();
    private static String sendData = new String();

    /* frame control */
    /* action control */
    private static Player player;
    private static Data_frame[] action = { null, null };
    private static pet[] battlePets = { null, null };

    // private SimpleClient sClient;
    /* action control */
    /* controling var */

    /* UI setting source */
    /* data of frame */

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

    /* Connection control */
    static SimpleClient sc;
    /* Connection control */

    public Battlefld(int w, int h, SimpleClient c, Player p) {
        super(w, h);
        player = p;
        player.get10RdPets();
        sc = c;

        /* for init pet */
        pet[] np = { player.getPets().get(0), gameRule.generatePet() };
        try {
            sendData = new String(
                    String.valueOf(np[0].getLife()) + "/" + String.valueOf(np[0].getSpeed()) + "/" + np[0].getName()
                            + "/" + "C" + "/" + "0" + "/" + np[0].getClass().getSimpleName() + "/" + np[0].getDefend());
            sc.battleFildDataTransform(sendData);
            action[0] = new Data_frame(sendData);
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        battlePets = np;
        /* for init pet */
        filesPath[0] = battlePets[0].sourceFIle;
        filesPath[1] = battlePets[1].sourceFIle;

        BattleIcon icon = new BattleIcon();
        icon.setBounds(0, 0, this.getWidth(), this.getHeight() - 200);
        add(icon);
        Dialog d = new Dialog(sourceWay + filesPath[4]);
        d.setBounds(0, 680, 570, 200);
        add(d);
        setVisible(true);
    }

    class BattleIcon extends JPanel {
        protected BattleIcon() {
            setLayout(null);

            for (int i = 0; i < 2; i++) {
                ImageIcon im = new ImageIcon(sourceWay + hpBar[0]);
                JLabel jb = new JLabel();
                jb.setIcon(im);
                jb.setBounds(hpBarDirction[i][0], hpBarDirction[i][1], hpBarDirction[i][2], hpBarDirction[i][3]);
                petUIList.add(jb);// 0 1
                add(jb);
            }
            for (int i = 0; i < 2; i++) {
                JLabel nJLabel = new JLabel(petsName[i]);
                nJLabel.setBounds(petsDirction[i][0], petsDirction[i][1], 100, 20);
                petUIList.add(nJLabel);// 2 3
                add(nJLabel);
            }
            for (int i = 0; i < 2; i++) {// armor
                JLabel nJLabel = new JLabel("0");
                nJLabel.setBounds(petsDirction[i][0] + 50, petsDirction[i][1], 50, 20);
                petUIList.add(nJLabel);// 4 5
                add(nJLabel);

            }
            for (int i = 0; i < 4; i++) {
                ImageIcon im = new ImageIcon(sourceWay + filesPath[i]);
                JLabel jb = new JLabel();
                jb.setIcon(im);
                if (i > 1)
                    jb.setOpaque(false);
                else
                    petUIList.add(jb);
                jb.setBounds(dirction[i][0], dirction[i][1], dirction[i][2], dirction[i][3]);

                add(jb);
            }

            //

            JLabel dLabel = new JLabel("Dialog");
            dLabel.setBounds(50, 320, 400, 20);
            dialogList.add(dLabel);
            add(dLabel);
        }
    }

    class Dialog extends JPanel {
        private ImageIcon dialogBack;
        private int i = 0;
        private String[] n = { "Select1", "Select2", "Select3", "Select4" };
        private int x = 10;
        private int y = 400;
        int[][] dic = { { x, y, 100, 100 }, { x + 145, y, 100, 100 }, { x, y + 65, 100, 100 },
                { x + 145, y + 65, 100, 100 } };
        private UIListener lisner = new UIListener();

        Dialog(String fileLocate) {

            setLayout(null);
            setName("name");
            dialogBack = new ImageIcon(fileLocate);
            JLabel bG = new JLabel();
            bG.setOpaque(false);
            bG.setIcon(dialogBack);
            bG.setBounds(0, 0, 570, 120);
            /* setting button */
            int i = 0;
            JButton nButton = new JButton(n[i]);
            nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
            nButton.addActionListener(lisner.new bListener1());
            add(nButton);

            i = 1;
            nButton = new JButton(n[i]);
            nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
            nButton.addActionListener(lisner.new bListener2());
            add(nButton);

            i = 2;
            nButton = new JButton(n[i]);
            nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
            nButton.addActionListener(lisner.new bListener3());
            add(nButton);

            i = 3;
            nButton = new JButton(n[i]);
            nButton.setBounds(dic[i][0], dic[i][1], 570 / 4, 120 / 2);
            nButton.addActionListener(lisner.new bListener4());
            add(nButton);
            /* setting button */
            /* set dialog */
            for (i = 0; i < 4; i++) {
                JLabel wordDialog = new JLabel(battlePets[0].skillList.get(i).getSkillName());
                wordDialog.setBounds(dic[i][0] + (i % 2 == 0 ? 300 : 280), dic[i][1], 100, 20);
                add(wordDialog);
                dialogList.add(wordDialog);
                System.out.println(dialogList.get(i + 1).getText());
            }
            new connectionListener();
            new gameRule();
            new UIupdate();
            lisner.update_skill();
        }
    }

    class connectionListener implements Runnable {
        SimpleClient sClient;

        /* only try to get data */
        connectionListener() {
            Thread t = new Thread(this);
            sClient = sc;
            t.start();
        }

        synchronized public void run() {
            while (true) {
                try {
                    action[1] = sClient.getDatf();
                    System.out.println("action: " + action[1]);
                    Thread.sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class gameRule implements Runnable {
        Data_frame[] nowAct = { null, null };
        int player;

        public gameRule() {
            Thread t = new Thread(this);
            t.start();
        }

        public static pet generatePet() {
            return new Monster1("pet");
        }

        public static pet generatePet(String select, String name) {
            pet p = null;
            switch (select) {
                case "Monster1":
                    p = new Monster1(name);
                    break;
                case "Monster1copy":
                    p = new Monster1copy(name);
                    break;
                case "Monster1copy2":
                    p = new Monster1copy2(name);
                    break;
                case "Monster1copy3":
                    p = new Monster1copy3(name);
                    break;
                case "Monster1copy4":
                    p = new Monster1copy4(name);
                    break;
                case "Monster1copy5":
                    p = new Monster1copy5(name);
                    break;
                case "Monster1copycat":
                    p = new Monster1copycat(name);
                    break;
                default:
                    p = new Monster1(name);
                    break;
            }
            return p;
        }

        @Override
        public synchronized void run() {
            while (true) {

                try {
                    Thread.sleep(2000);
                    if (action[0] != null && action[1] != null) {
                        /* compare speed */
                        System.out.println("comped");
                        if (action[0].getSpeed() >= action[1].getSpeed()) {
                            if (action[0].getSpeed() == 0) {
                                Data_frame[] n = { action[1], action[0] };
                                nowAct = n;
                            } else {
                                Data_frame[] n = { action[0], action[1] };
                                nowAct = n;
                            }
                            ;

                        } else {
                            Data_frame[] n = { action[1], action[0] };
                            nowAct = n;
                        }
                        /* compare speed */
                        for (int i = 0; i < 2; i++) {// first do and second do
                            Data_frame ingFrame = nowAct[i];
                            switch (ingFrame.getAct_type()) {
                                case 'C':// changing name and typename (actname)
                                    battlePets[i] = generatePet(ingFrame.getAct_name(), ingFrame.getName());
                                    dialogList.get(0)
                                            .setText(new String().format("changed, come on %s", ingFrame.getName()));
                                    System.out.println(battlePets[0].getName());
                                    System.out.println(battlePets[1].getName());
                                    break;
                                case 'A':// do attack to another
                                    battlePets[(i + 1) % 2].fight(ingFrame.getAct_num());
                                    dialogList.get(0)
                                            .setText(new String().format("%s use %s, %d hp left", ingFrame.getName(),
                                                    ingFrame.getAct_name(), ingFrame.getHp() - ingFrame.getAct_num()));
                                    break;
                                case 'H':// heal self
                                    battlePets[i].heal(ingFrame.getAct_num());
                                    dialogList.get(0)
                                            .setText(new String().format("%s use %s, %d hp left", ingFrame.getName(),
                                                    ingFrame.getAct_name(), ingFrame.getHp() - ingFrame.getAct_num()));
                                    break;
                                case 'R':// armour self
                                    battlePets[i].armerUp(ingFrame.getAct_num());
                                    dialogList.get(0).setText(new String().format("%s use %s, armorUp %d ",
                                            ingFrame.getName(), ingFrame.getAct_name(), ingFrame.getAct_num()));
                                    break;
                            }
                        }

                        Data_frame[] n = { null, null };
                        nowAct = n;
                        action = n;
                        sc.setDatf(null);
                    }
                    if (!battlePets[0].isAlive()) {
                        dialogList.get(0).setText(new String().format("You Lose"));
                    } else if (!battlePets[1].isAlive()) {
                        dialogList.get(0).setText(new String().format("You Win"));
                    } else if (!(battlePets[0].isAlive() && battlePets[1].isAlive())) {
                        dialogList.get(0).setText(new String().format("Draw"));
                    } else {

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }

            }
        }
    }

    static class UIListener {
        skill[] skillList;
        SimpleClient sClient;

        UIListener() {
            skillList = new skill[4];
            sClient = sc;
        }

        void update_skill() {
            try {
                for (int i = 0; i < 4; i++) {

                    if (battlePets[0] != null) {
                        skillList[i] = battlePets[0].getSkillList().get(i);
                        dialogList.get(i + 1).setText(skillList[i].getSkillName());
                    }
                }
            } catch (Exception e) {
                // System.err.println(e);
                e.printStackTrace();
            }

        }

        // only send data
        class bListener1 implements ActionListener {
            private int i = 0;

            public bListener1() {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // do the action and send to sever
                sendData = new String(String.valueOf(battlePets[0].getLife()) + "/"
                        + String.valueOf(battlePets[0].getSpeed()) + "/" + battlePets[0].getName() + "/"
                        + skillList[i].getSkillType() + "/" + String.valueOf(skillList[i].getSkillPow()) + "/"
                        + skillList[i].getSkillName() + "/" + battlePets[0].getDefend());

                // nClient.battleFildDataTransform(sendData);
                if (battlePets[0].isAlive()) {
                    action[0] = new Data_frame(sendData);
                    sc.battleFildDataTransform(sendData);
                    System.out.println(sendData);
                }
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
                sendData = new String(String.valueOf(battlePets[0].getLife()) + "/"
                        + String.valueOf(battlePets[0].getSpeed()) + "/" + battlePets[0].getName() + "/"
                        + skillList[i].getSkillType() + "/" + String.valueOf(skillList[i].getSkillPow()) + "/"
                        + skillList[i].getSkillName() + "/" + battlePets[0].getDefend());
                if (battlePets[0].isAlive()) {
                    action[0] = new Data_frame(sendData);
                    sc.battleFildDataTransform(sendData);
                    System.out.println(sendData);
                }
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
                sendData = new String(String.valueOf(battlePets[0].getLife()) + "/"
                        + String.valueOf(battlePets[0].getSpeed()) + "/" + battlePets[0].getName() + "/"
                        + skillList[i].getSkillType() + "/" + String.valueOf(skillList[i].getSkillPow()) + "/"
                        + skillList[i].getSkillName() + "/" + battlePets[0].getDefend());
                // nClient.battl eFildDataTransform(sendData);
                if (battlePets[0].isAlive()) {
                    action[0] = new Data_frame(sendData);
                    sc.battleFildDataTransform(sendData);
                    System.out.println(sendData);
                }
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
                sendData = new String(String.valueOf(battlePets[0].getLife()) + "/"
                        + String.valueOf(battlePets[0].getSpeed()) + "/" + battlePets[0].getName() + "/"
                        + skillList[i].getSkillType() + "/" + String.valueOf(skillList[i].getSkillPow()) + "/"
                        + skillList[i].getSkillName() + "/" + battlePets[0].getDefend());
                if (battlePets[0].isAlive()) {
                    action[0] = new Data_frame(sendData);
                    sc.battleFildDataTransform(sendData);
                    System.out.println(sendData);
                }
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
                ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                if (30 < battlePets[i].getLife() && battlePets[i].getLife() < 50) {
                    n = new ImageIcon(sourceWay + hpBar[1]);
                }
                if (50 < battlePets[i].getLife()) {
                    n = new ImageIcon(sourceWay + hpBar[0]);
                }
                if (battlePets[i].getLife() < 30) {
                    n = new ImageIcon(sourceWay + hpBar[2]);

                }
                try {
                    petUIList.get(i).setIcon(n);
                } catch (Exception e) {
                    e.printStackTrace();// TODO: handle exception
                }

                /*
                 * int b = (int) Math .round((battlePets[i].getLife() /
                 * battlePets[i].getLife_MAX()) * petUIList.get(i).getWidth());
                 */
                // System.out.println(">>" + n);
                petUIList.get(i).setBounds(petUIList.get(i).getX(), petUIList.get(i).getY(), battlePets[i].getLife(),
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
        public synchronized void run() {
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
