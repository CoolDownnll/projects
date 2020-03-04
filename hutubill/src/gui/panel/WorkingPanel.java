package gui.panel;
 
import javax.swing.JPanel;
 
/**
 * 工具面板类
 * @author OCEAN
 *
 */
public abstract class WorkingPanel  extends JPanel{
	
	public abstract void addListener();
    public abstract void updateData();
}