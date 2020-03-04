package gui.panel;
 
import javax.swing.JButton;
 
import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;
 
/**
 * 数据库恢复面板类
 * @author OCEAN
 *
 */
public class RecoverPanel extends WorkingPanel {
	
    static{
        GUIUtil.useLNF();
    }
    
    public static RecoverPanel instance = new RecoverPanel();
 
    
    public JButton bRecover =new JButton("恢复");
 
    
    public RecoverPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
         
        addListener();
    }
 
 
    @Override
    public void updateData() {
    }
 
    
    @Override
    public void addListener() {
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }
 
}