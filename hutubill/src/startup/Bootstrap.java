package startup;
 
import javax.swing.SwingUtilities;
 
import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;
 
/**
 * 程序启动入口类
 * @author OCEAN
 *
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();   // 在这里设置了皮肤，其他的Panel类里就不需要进行皮肤设置了
 
        SwingUtilities.invokeAndWait(new Runnable() {  // 启动图形界面
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);   // 显示主窗体
                MainPanel.instance.workingPanel.show(SpendPanel.instance);  // 让主面板下方的workingPanel显示消费一览Panel
            }
        });
    }
}