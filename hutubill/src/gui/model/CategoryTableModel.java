package gui.model;
  
import java.util.List;
 
import javax.swing.table.AbstractTableModel;
 
import entity.Category;
import service.CategoryService;
  
/**
 * 分类表格Model类
 * @author OCEAN
 *
 */
public class CategoryTableModel extends AbstractTableModel {
  
    String[] columnNames = new String[] { "分类名称","消费次数"};
  
    // 使用从Service返回的List作为TableModel的数据
    public List<Category> cs = new CategoryService().list();

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h = cs.get(rowIndex);   // 获取行对应的Category对象
        // 根据columnIndex返回对应的属性 
        if (0 == columnIndex)
            return h.name;
        if (1 == columnIndex)
            return h.recordNumber;
 
        return null;
    }
    
    
    @Override
    public int getRowCount() {
        return cs.size();
    }
  
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
  
    
/*    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
  
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }*/
  
}