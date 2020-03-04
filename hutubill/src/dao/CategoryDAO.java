package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import util.DBUtil;

/**
 * Category类持久层
 * @author OCEAN
 *
 */
public class CategoryDAO {
 
	/**
	 * 添加
	 * @param category
	 */
    public void add(Category category) {
        String sql = "insert into category values(null,?)";
        
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, category.name);
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                category.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    
    /**
     * 根据id删除
     * @param id
     */
    public void delete(int id) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from category where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 更新
     * @param category
     */
    public void update(Category category) {
        String sql = "update category set name_= ? where id = ?";
        
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, category.name);
            ps.setInt(2, category.id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
 
    /**
     * 根据id获取
     * @param id
     * @return
     */
    public Category get(int id) {
        Category category = null;
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from category where id = " + id;
 
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                category = new Category();
                String name = rs.getString(2);
                category.name = name;
                category.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return category;
    }
 
    
    /**
     * 查询所有
     * @return
     */
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }
 
    
    /**
     * 分页查询
     * @param start
     * @param count
     * @return
     */
    public List<Category> list(int start, int count) {
        List<Category> categorys = new ArrayList<Category>();
 
        String sql = "select * from category order by id desc limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Category category = new Category();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                category.id = id;
                category.name = name;
                categorys.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return categorys;
    }
 
    
    /**
     * 统计总数
     * @return
     */
    public int getTotal() {
        int total = 0;
        
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from category";
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
 
            System.out.println("total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return total;
    }
}