package gui.panel;
 
import java.awt.BorderLayout;
 
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
 
import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;
 
/**
 * 主窗体面板类：北边是一个工具条，中间是一个空白的Panel：用于将来显示不同的功能面板
 * @author OCEAN
 *
 */
public class MainPanel extends JPanel {
	
    static {
    	/*
    	 * 因为这句话必须加在第一行才能保证生效，所以可放在静态代码快中
    	 */
        GUIUtil.useLNF();
    }
 
    
    public static MainPanel instance = new MainPanel();  // 面板类设计为单例模式
    public JToolBar tb = new JToolBar();   // 组件设置为public
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();
 
    
    public CenterPanel workingPanel;  // 工作面板，用于将来显示不同的功能面板
 
    
    private MainPanel() {
 
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
 
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);
 
        workingPanel = new CenterPanel(0.8);
 
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
         
        addListener();   
    }
 
    
    /**
     * 实例化一个ToolBarListener监听器，工具栏上的按钮都加上这个监听器对象即可
     */
    private void addListener() {
        ToolBarListener listener = new ToolBarListener();
         
        bSpend.addActionListener(listener);
        bRecord.addActionListener(listener);
        bCategory.addActionListener(listener);
        bReport.addActionListener(listener);
        bConfig.addActionListener(listener);
        bBackup.addActionListener(listener);
        bRecover.addActionListener(listener);
    }
 
}