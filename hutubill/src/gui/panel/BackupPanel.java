package gui.panel;
 
import javax.swing.JButton;
 
import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;
 
/**
 * 数据库备份面板类
 * @author OCEAN
 *
 */
public class BackupPanel extends WorkingPanel {
	
    static {
        GUIUtil.useLNF();
    }
 
    public static BackupPanel instance = new BackupPanel();
    
    
    public JButton bBackup = new JButton("备份");
 
    
    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        addListener();
    }
 
    
    @Override
    public void updateData() {
    }
 
    
    @Override
    public void addListener() {
        BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
    }
 
}