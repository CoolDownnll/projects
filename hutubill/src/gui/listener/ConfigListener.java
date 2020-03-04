package gui.listener;
 
import java.awt.event.ActionEvent;
 
import java.awt.event.ActionListener;
import java.io.File;
 
import javax.swing.JOptionPane;
 
import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;
 
/**
 * Config类监听器：此监听器作用在设置面板上的更新按钮
 * @author OCEAN
 *
 */
public class ConfigListener implements ActionListener{
 
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;
        
        if(!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
            return;
        String mysqlPath =p.tfMysqlPath.getText();
        if(0 != mysqlPath.length()){
            File commandFile = new File(mysqlPath, "bin/mysql.exe");   // 判断MYSQL安装路径对应的bin子目录下是否有mysql.exe文件存在
            if(!commandFile.exists()){
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }
         
        
        ConfigService cs= new ConfigService();
        cs.update(ConfigService.budget,p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath,mysqlPath);
         
        JOptionPane.showMessageDialog(p, "设置修改成功");   // 提示设置修改成功
    }
 
}