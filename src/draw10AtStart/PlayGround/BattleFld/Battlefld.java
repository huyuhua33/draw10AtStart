package draw10AtStart.PlayGround.BattleFld;

import java.util.ArrayList;

import javax.swing.JLabel;

import ClientServer.Data_frame;
import ClientServer.Client.SimpleClient;
import draw10AtStart.PlayGround.Frame;

public class Battlefld extends Frame {
    /* controling var */
    /* frame control */
    private ArrayList<JLabel> dialogList;
    private ArrayList<JLabel> petUIList;
    /* frame control */
    /* action control */
    private Data_frame[] action = { null, null };
    // private SimpleClient sClient;
    /* action control */
    /* controling var */

    /* UI setting source */
    /* monster and hpbar */
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

        }
    }

    class UIListener {

    }

    class UIupdate {
        void hpUpdate() {

        }
    }
}
