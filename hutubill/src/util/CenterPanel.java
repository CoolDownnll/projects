package util;
 
import java.awt.Component;
import java.awt.Dimension;
 
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import gui.panel.WorkingPanel;
 
/**
 * 居中面板工具类
 * @author OCEAN
 *
 */
public class CenterPanel extends JPanel {
 
    private double rate;      // 拉伸比例:1就是填满，0.5就是填一半
    private JComponent c;     // 显示的组件
    private boolean strech;   // 是否拉伸
    public CenterPanel(double rate, boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }
    public CenterPanel(double rate) {
        this(rate, true);
    }
    

    
    /**
     * 显示组件
     * @param p
     */
    public void show(JComponent p) {
    	this.c = p;
    	Component[] cs = getComponents();
    	for (Component c : cs) {
    		remove(c);
    	}
    	add(p);
    	
    	if (p instanceof WorkingPanel)
    		((WorkingPanel) p).updateData();   // 点击工具栏上的按钮，不仅可以切换到不同的面板，而且面板上的数据也是从数据库中更新出的
    	
    	this.updateUI();   // 该方法会导致swing去调用repaint()方法
    }
    
    
 
    public void repaint() {
        if (null != c) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();
 
            if (strech)
                c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            else
                c.setSize(componentSize);
 
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
                    containerSize.height / 2 - c.getSize().height / 2);
        }
        super.repaint();
    }
 
    
 
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(0.85, true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b = new JButton("abc");
        cp.show(b);
    }
 
}