package gui.model;
 
import java.util.List;
 
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
 
import entity.Category;
import service.CategoryService;
 
/**
 * 分类下拉框Model类
 *   注：使用该Model类将下拉框中的数据分离开来，便于信息更新(因为信息是从数据库中查出来的)
 * @author OCEAN
 *
 */
public class CategoryComboBoxModel implements ComboBoxModel<Category>{
 
    public List<Category> cs = new CategoryService().list();// 表示分类集合信息
     
    public Category c;  // 表示被选中的分类
    
    
    public CategoryComboBoxModel(){
        if(!cs.isEmpty())
            c=cs.get(0);
    }
    
    
    /*
     * 获取下拉框的大小
     */
    @Override
    public int getSize() {
        return cs.size();
    }
 
    
    /*
     * 获取指定位置的数据
     */
    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }
 
    
    /*
     * 当界面上选中了某一个下拉框项，就会调用这个方法
     */
    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }
 
    
    /*
     * 获取被选中的数据
     */
    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty())
            return c;
        else
            return null;
 
    }
    
    
    @Override
    public void addListDataListener(ListDataListener l) {
    }
 
    
    @Override
    public void removeListDataListener(ListDataListener l) {
    }
 
}