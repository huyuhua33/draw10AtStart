package draw10AtStart.PlayGround;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class Frame extends JFrame {
    private ArrayList<JComponent> frameComponenList;
    private ArrayList<JComponent> tmpComponenList;
    private int frameSize_weith;
    private int frameSize_height;
    private Frame nextFrame;

    public void frameUpdate() {
        tmpComponenList = frameComponenList;
        for (int i = 0; i < frameComponenList.size(); i++) {
            frameComponenList.remove(i);
        }
        frameComponenList.addAll(tmpComponenList);
        
        revalidate();
    }

    public Frame frameChanging() {
        this.setVisible(false);
        this.dispose();
        return this.nextFrame;
    }

    public Frame(int w, int h, Frame n) {
        this.frameComponenList = new ArrayList<JComponent>();
        this.tmpComponenList = new ArrayList<JComponent>();
        this.frameSize_weith = w;
        this.frameSize_height = h;
        nextFrame = n;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ArrayList<JComponent> getFrameComponenList() {
        return frameComponenList;
    }

    public void setFrameComponenList(ArrayList<JComponent> frameComponenList) {
        this.frameComponenList = frameComponenList;
    }

    public ArrayList<JComponent> getTmpComponenList() {
        return tmpComponenList;
    }

    public void setTmpComponenList(ArrayList<JComponent> tmpComponenList) {
        this.tmpComponenList = tmpComponenList;
    }

    public int getFrameSize_weith() {
        return frameSize_weith;
    }

    public void setFrameSize_weith(int frameSize_weith) {
        this.frameSize_weith = frameSize_weith;
    }

    public int getFrameSize_height() {
        return frameSize_height;
    }

    public void setFrameSize_height(int frameSize_height) {
        this.frameSize_height = frameSize_height;
    }
}
