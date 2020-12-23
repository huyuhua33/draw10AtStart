package draw10AtStart.PlayGround.BattleFiled;

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
import charater.Monster.Monster1copycat;
import charater.Player.Player;
import charater.Player.pet;
import draw10AtStart.PlayGround.Frame;
import charater.Monster.*;

public class BattleFiled extends Frame {
    private String[] n = { "ATk[1]", "BAG[2]", "PET[3]", "RUN[4]" };
    private String sourceWay = new String("sprit");
    private String[] filesPath = { "\\monster\\battle_background.jpg", "\\monster\\battle_background.jpg",
            "\\healthBar\\hp0_right.jpg", "\\healthBar\\hp0_left.jpg", "\\dialog\\dialog.jpg" };
    private int[][] dirction = { { 400, 50, 100, 100 }, { 50, 200, 100, 100 }, { 300, 210, 230, 100 },
            { 50, 30, 230, 100 } };

    private String[] hpBar = { "\\healthBar\\full-hp.jpg", "\\healthBar\\half-hp.jpg", "\\healthBar\\non-hp.jpg" };
    private int[][] hpBarDirction = { { dirction[2][0] + 65, dirction[2][1] + 47, 99, 4 },
            { dirction[3][1] + 65, dirction[3][1] + 47, 99, 4 } };
    private String[] petsName = { "Pet1", "Pet2" };
    private int[][] petsDirction = { { dirction[2][0] + 57, dirction[2][1] + 27 },
            { dirction[3][1] + 55, dirction[3][1] + 27 } };

    /* 可變更變數 */
    private ArrayList<JLabel> lArrayList;
    private ArrayList<JLabel> petUiList;
    private JLabel[] hpBars = { null, null, null, null };
    private pet[] battlePets = { null, null };

    private int att[][];
    private Dialog ddialog;
    private Player player;
    Double caculated;
    private String sendData;
    protected SimpleClient nClient;
    protected skill[] skillList = new skill[4];
    petAction pac;

    public BattleFiled(int w, int h, SimpleClient c) {
        super(w, h);
        // tmp
        battlePets[0] = (pet) new Monster1("AA");

        for (int i = 0; i < 4; i++) {
            skillList[i] = battlePets[0].skillList.get(i);
        }
        player = new Player("A", "b");
        player.get10RdPets();
        battlePets[1] = (pet) new Monster1copycat("cc");

        lArrayList = new ArrayList<JLabel>();
        petUiList = new ArrayList<JLabel>();
        this.setLayout(null);
        pac = new petAction();
        // ArrayList<JComponent> battleFildGUIComponent = new ArrayList<JComponent>();

        BattleIcon nIcon = new BattleIcon();
        nIcon.setBounds(0, 0, this.getWidth(), this.getHeight() - 200);
        /* setting dialog words */
        Dialog dialogPanel = new Dialog(sourceWay + filesPath[4]);
        dialogPanel.setBounds(0, this.getHeight() - 200, this.getWidth(), 250);
        String testWords = new String("waiting for battle.");
        // f.add(btf);
        /* connection */
        BattleFiledConnector sc = new BattleFiledConnector(c);
        sendData = 0 + "/" + 0 + "/" + player.getPets().get(0).getName() + "/" + "C" + "/" + 0 + "/" + "Monster1" + "/"
                + 0;
        nClient.battleFildDataTransform(sendData);

        add(nIcon);
        add(dialogPanel);
        setVisible(true);
    }

    class petAction {

        protected void hpBarSetting(JLabel h, Double w) {
            if (w < 50.0) {
                ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                h.remove(h);
                h.setIcon(n);
            }
            if (w > 50.0) {
                ImageIcon n = new ImageIcon(sourceWay + hpBar[0]);
                h.remove(h);
                h.setIcon(n);
            }
            if (w < 20.0) {
                ImageIcon n = new ImageIcon(sourceWay + hpBar[2]);
                h.remove(h);
                h.setIcon(n);
            }
            if (w <= 0)
                w = 0.0;
            int n = (int) Math.round(w * h.getWidth());
            System.out.println(">>" + n);
            h.setBounds(h.getX(), h.getY(), n, h.getHeight());// TODO //
            // Auto-generate
        }

        void analyzingpack(String d, int who) {
            String[] sc1Data = d.split("/");
            Data_frame data = new Data_frame(Integer.parseInt(sc1Data[0]), Integer.parseInt(sc1Data[1]), sc1Data[2],
                    sc1Data[3].charAt(0), Integer.parseInt(sc1Data[4]), sc1Data[5], Integer.parseInt(sc1Data[6]));
            if (data.getAct_type() == 'A') {// Attack
                battlePets[(who + 1) % 2].fight(data.getAct_num());
            }
            if (data.getAct_type() == 'H') {// region
                battlePets[who].heal(data.getAct_num());
            }
            if (data.getAct_type() == 'R') {// armor up
                battlePets[who].armerUp(data.getAct_num());
            }
            if (data.getAct_type() == 'C') {// change pet
                battlePets[who] = generatePet(data.getAct_name(), data.getName());
            }
            petUiList.get(0).setText(battlePets[0].getName());
            petUiList.get(1).setText(battlePets[1].getName());
            caculated = (double) battlePets[0].getLife() / battlePets[0].getLife_MAX();
            hpBarSetting(hpBars[0], caculated);
            System.out.println("pet 1" + caculated);
            hpBars[2].setText(String.valueOf(battlePets[0].getDefend()));
            caculated = (double) battlePets[1].getLife() / battlePets[1].getLife_MAX();
            hpBarSetting(hpBars[1], caculated);
            hpBars[3].setText(String.valueOf(battlePets[1].getDefend()));
            System.out.println("pet 2" + caculated);

            System.out.println(data);
        }

        public pet generatePet(String select, String name) {
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

    }

    class BattleFiledConnector implements Runnable {

        Data_frame data;
        boolean stop = false;

        public BattleFiledConnector(SimpleClient nCli) {
            Thread t = new Thread();
            nClient = nCli;
            t.start();
            stop = false;
        }

        protected void hpBarSetting(JLabel h, Double w) {
            if (w < 50.0) {
                ImageIcon n = new ImageIcon(sourceWay + hpBar[1]);
                h.remove(h);
                h.setIcon(n);
            }
            if (w > 50.0) {
                ImageIcon n = new ImageIcon(sourceWay + hpBar[0]);
                h.remove(h);
                h.setIcon(n);
            }
            if (w < 20.0) {
                ImageIcon n = new ImageIcon(sourceWay + hpBar[2]);
                h.remove(h);
                h.setIcon(n);
            }
            if (w <= 0)
                w = 0.0;
            int n = (int) Math.round(w * h.getWidth());
            System.out.println(">>" + n);
            h.setBounds(h.getX(), h.getY(), n, h.getHeight());// TODO //
            // Auto-generate
        }

        public pet generatePet(String select, String name) {
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
        public void run() {
            /*
             * Data_frame(Integer.parseInt(sc1Data[0]), Integer.parseInt(sc1Data[1]),
             * sc1Data[2], sc1Data[3].charAt(0), Integer.parseInt(sc1Data[4]), sc1Data[5])
             */

            while (true)// before connection is stop
            {

                do {// what enemy do
                    data = nClient.getDatf();
                    System.out.println(data);
                    if (data.getAct_type() == 'A') {// Attack
                        battlePets[0].fight(data.getAct_num());
                    }
                    if (data.getAct_type() == 'H') {// region
                        battlePets[1].heal(data.getAct_num());
                    }
                    if (data.getAct_type() == 'R') {// armor up
                        battlePets[1].armerUp(data.getAct_num());
                    }
                    if (data.getAct_type() == 'C') {// change pet
                        battlePets[1] = generatePet(data.getAct_name(), data.getName());
                        petUiList.get(1).setText(battlePets[1].getName());
                    }
                    petUiList.get(0).setText(battlePets[0].getName());
                    petUiList.get(1).setText(battlePets[1].getName());
                    caculated = (double) battlePets[0].getLife() / battlePets[0].getLife_MAX();
                    hpBarSetting(hpBars[0], caculated);
                    System.out.println("pet 1" + caculated);
                    hpBars[2].setText(String.valueOf(battlePets[0].getDefend()));
                    caculated = (double) battlePets[1].getLife() / battlePets[1].getLife_MAX();
                    hpBarSetting(hpBars[1], caculated);
                    hpBars[3].setText(String.valueOf(battlePets[1].getDefend()));
                    System.out.println("pet 2" + caculated);

                    System.out.println(data);
                    if (!battlePets[0].isAlive()) {
                        stop = true;
                    }
                    if (!battlePets[1].isAlive()) {
                        stop = true;
                    }
                } while (!stop);// way to stop
            }
        }
    }

    class BattleIcon extends JPanel {
        protected BattleIcon() {
            setLayout(null);
            setBounds(0, 0, this.getWidth(), this.getHeight() - 200);
            att = hpBarDirction;
            for (int i = 0; i < 2; i++) {
                JLabel nJLabel = new JLabel(petsName[i]);
                nJLabel.setBounds(petsDirction[i][0], petsDirction[i][1], 100, 20);
                petUiList.add(nJLabel);
                add(nJLabel);
            }
            for (int i = 0; i < 2; i++) {
                ImageIcon im = new ImageIcon(sourceWay + hpBar[0]);
                JLabel jb = new JLabel();
                jb.setIcon(im);
                jb.setBounds(hpBarDirction[i][0], hpBarDirction[i][1], hpBarDirction[i][2], hpBarDirction[i][3]);
                hpBars[i] = jb;
                add(jb);
            }
            for (int i = 0; i < 4; i++) {
                ImageIcon im = new ImageIcon(sourceWay + filesPath[i]);
                JLabel jb = new JLabel();
                jb.setIcon(im);
                if (i > 1)
                    jb.setOpaque(false);
                else
                    petUiList.add(jb);
                jb.setBounds(dirction[i][0], dirction[i][1], dirction[i][2], dirction[i][3]);

                add(jb);
            }
            for (int i = 0; i < 2; i++) {
                JLabel nJLabel = new JLabel("20");
                nJLabel.setBounds(petsDirction[i][0] + 20, petsDirction[i][1] + 20, 50, 50);
                hpBars[i + 2] = nJLabel;
                add(nJLabel);

            }
            JLabel dLabel = new JLabel("Dialog");
            dLabel.setBounds(50, 320, 100, 20);
            lArrayList.add(dLabel);
            add(dLabel);
        }
    }

    class Dialog extends JPanel {
        private ImageIcon dialogBack;
        private int i = 0;
        private String[] n = { "Select1", "Select2", "Select3", "Select4" };
        private int x = 10;
        private int y = 10;
        int[][] dic = { { x, y, 100, 100 }, { x + 145, y, 100, 100 }, { x, y + 65, 100, 100 },
                { x + 145, y + 65, 100, 100 } };

        Dialog(String fileLocate) {
            setLayout(null);
            setName("name");
            dialogBack = new ImageIcon(fileLocate);
            JLabel bG = new JLabel();
            bG.setOpaque(false);
            bG.setIcon(dialogBack);
            bG.setBounds(0, 0, 570, 120);
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
            skill[][] sklist = { { null, null, null, null } };
            for (i = 0; i < 4; i++) {
                JLabel wordDialog = new JLabel(battlePets[0].skillList.get(i).getSkillName());
                sklist[0][i] = battlePets[0].skillList.get(i);
                wordDialog.setBounds(dic[i][0] + (i % 2 == 0 ? 300 : 280), dic[i][1], 100, 20);
                add(wordDialog);
                lArrayList.add(wordDialog);
            }
        }

        // when btn clicked, do change self state
        class bListener1 implements ActionListener {
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
                battlePets[1].setLife(battlePets[1].getLife() - 10);
                // nClient.battleFildDataTransform(sendData);
                pac.analyzingpack(sendData, 0);
                System.out.println(sendData);
                lArrayList.get(1).setText("btn1 clicked");
                lArrayList.get(0).setText("btn1 clicked");
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
                // nClient.battleFildDataTransform(sendData);
                pac.analyzingpack(sendData, 0);
                System.out.println(sendData);
                lArrayList.get(2).setText("btn2 clicked");
                lArrayList.get(0).setText("btn2 clicked");
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
                pac.analyzingpack(sendData, 0);
                System.out.println(sendData);
                lArrayList.get(3).setText("btn3 clicked");
                lArrayList.get(0).setText("btn3 clicked");
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
                System.out.println(sendData);
                // nClient.battleFildDataTransform(sendData);
                pac.analyzingpack(sendData, 0);

                lArrayList.get(4).setText("btn4 clicked");
                lArrayList.get(0).setText("btn4 clicked");
            }
        }
    }

}
