package draw10AtStart;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class Frame extends JFrame{
    private ArrayList<JComponent> frameComponenList;
    private ArrayList<JComponent> tmpComponenList;
    public abstract void frameUpdate(ArrayList<JComponent> frameComp);
    public Frame()
    {
        frameComponenList = new ArrayList<JComponent>();
        tmpComponenList = new ArrayList<JComponent>;
    }
}
