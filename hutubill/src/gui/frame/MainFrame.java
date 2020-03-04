package gui.frame;
 
import javax.swing.JFrame;

import gui.panel.MainPanel;
 
/**
 * 主窗体类
 *   注：其他界面类都是面板类，不能独立运行，需要此类来容纳那些面板类
 * @author OCEAN
 *
 */
public class MainFrame extends JFrame{
    public static MainFrame instance = new MainFrame();
     
    
    private MainFrame(){
        this.setSize(500,450);
        this.setTitle("一本糊涂账");
        this.setContentPane(MainPanel.instance); // 把MainPanel设置为内容面板
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
}