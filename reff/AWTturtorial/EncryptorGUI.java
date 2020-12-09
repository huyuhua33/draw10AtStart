import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EncryptorGUI {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel msglabel;
    private JTabbedPane tabbedPane;
    private JTabbedPane bodyTabbedPane;
    private JPanel favoritePanel;
    private JPanel historyPanel;
    private JPanel recyclePanel;
    private JPanel configPanel;
    private JPanel aboutPanel;

    public EncryptorGUI() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("aaaa");
        mainFrame.setSize(1024, 768);
        mainFrame.setLayout(new BorderLayout());

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        statusLabel = new JLabel("aaaa", JLabel.CENTER);
        msglabel = new JLabel("bbbb", JLabel.CENTER);
        tabbedPane = new JTabbedPane();

        mainFrame.add(tabbedPane, BorderLayout.CENTER);
        mainFrame.add(msglabel, BorderLayout.NORTH);
        mainFrame.add(statusLabel, BorderLayout.SOUTH);

    }

    private void buildHome() {
        ImageIcon icon = null;
        bodyTabbedPane = new JTabbedPane();
        bodyTabbedPane.setTabPlacement(JTabbedPane.LEFT);
        for (int i = 0; i < 9; i++) {
            bodyTabbedPane.addTab("Tab" + i, icon, new JButton("c" + i), "c" + i);
        }

        tabbedPane.addTab(" Home ", icon, bodyTabbedPane, "Home");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    }

    private void buildFavorite() {
        ImageIcon icon = null;
        favoritePanel = new JPanel();
        tabbedPane.addTab(" Favorites ", icon, favoritePanel, "f");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    }

    private void buildHistory() {
        ImageIcon icon = null;
        historyPanel = new JPanel();
        tabbedPane.addTab(" History ", icon, historyPanel, "History");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    }

    private void buildRecycle() {
        ImageIcon icon = null;
        recyclePanel = new JPanel();
        tabbedPane.addTab(" Recycle ", icon, recyclePanel, "Recycle");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
    }

    private void buildConfig() {
        ImageIcon icon = null;
        configPanel = new JPanel();
        tabbedPane.addTab(" Config ", icon, configPanel, "Config");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
    }

    private void buildAbout() {
        ImageIcon icon = null;
        aboutPanel = new JPanel();
        tabbedPane.addTab(" About ", icon, aboutPanel, "About");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);
    }

    public void showJFrame() {

        buildHome();

        buildFavorite();
        buildHistory();
        buildRecycle();
        buildConfig();
        buildAbout();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EncryptorGUI mainUI = new EncryptorGUI();
                mainUI.showJFrame();
            }
        });

    }
}