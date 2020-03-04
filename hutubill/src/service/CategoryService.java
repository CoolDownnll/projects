package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;
 
/**
 * Category类业务层
 * @author OCEAN
 *
 */
public class CategoryService {
    CategoryDAO categoryDao = new CategoryDAO();
    RecordDAO recordDao = new RecordDAO();
    
    /**
     * 增加一种分类
     * @param name
     */
    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }
    
    
    /**
     * 删除分类
     * @param id
     */
    public void delete(int id) {
    	categoryDao.delete(id);
    }
    
    
    /**
     * 更新分类
     * @param id
     * @param name
     */
    public void update(int id, String name) {
    	Category c = new Category();
    	c.setName(name);
    	c.setId(id);
    	categoryDao.update(c);
    }
    
    
    /**
     * 查询出所有的Category，然后根据每种分类再把分类对应的消费记录总数查出来，将消费频率高的分类放在前面
     * @return
     */
    public List<Category> list() {
        List<Category> cs = categoryDao.list();
        for (Category c : cs) {
            List<Record> rs = recordDao.list(c.id);
            c.recordNumber = rs.size();
        }
        Collections.sort(cs, (c1,c2) -> c2.recordNumber - c1.recordNumber);   // jdk1.8的新特性：Lambda 表达式
/*        Collections.sort(cs, new Comparator<Category>() {
			@Override
			public int compare(Category c1, Category c2) {
				return c2.recordNumber-c1.recordNumber;
			}
		});*/
		
		
        return cs;
    }
 
}