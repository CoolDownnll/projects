package dao;
 
import java.sql.Connection;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import entity.Record;
import util.DBUtil;
import util.DateUtil;
 
/**
 * Record类持久层
 * @author OCEAN
 *
 */
public class RecordDAO {
  
	/**
	 * 添加
	 * @param record
	 */
    public void add(Record record) {
        String sql = "insert into record values(null,?,?,?,?)";
        
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, record.spend);
            ps.setInt(2, record.cid);
            ps.setString(3, record.comment);
            ps.setDate(4, DateUtil.util2sql(record.date));
            ps.execute();
  
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                record.id = id;
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
            String sql = "delete from record where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 更新
     * @param record
     */
    public void update(Record record) {
        String sql = "update record set spend = ?, cid = ?, comment_ = ?, date_ = ? where id = ?";
        
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
        	ps.setInt(1, record.spend);
	        ps.setInt(2, record.cid);
	        ps.setString(3, record.comment);
	        ps.setDate(4, DateUtil.util2sql(record.date));
	        ps.setInt(5, record.id);
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
    public Record get(int id) {
        Record record = null;
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from record where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                record = new Record();
                int spend = rs.getInt("spend");
                int cid = rs.getInt("cid");
                String comment = rs.getString("comment_");
                Date date = rs.getDate("date_");
                 
                record.spend=spend;
                record.cid=cid;
                record.comment=comment;
                record.date=date;
                record.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return record;
    }
  
    
    /**
     * 查询所有
     * @return
     */
    public List<Record> list() {
        return list(0, Short.MAX_VALUE);
    }
     
    
    /**
     * 分页查询
     * @param start
     * @param count
     * @return
     */
    public List<Record> list(int start, int count) {
        List<Record> records = new ArrayList<Record>();
  
        String sql = "select * from record order by id desc limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                int id = rs.getInt("id");
                int spend = rs.getInt("spend");
                int cid = rs.getInt("cid");
                 
                String comment = rs.getString("comment_");
                Date date = rs.getDate("date_");
                  
                record.spend=spend;
                record.cid=cid;
                record.comment=comment;
                record.date=date;
                record.id = id;
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return records;
    }
     
    
    /**
     * 根据分类查询
     * @param cid
     * @return
     */
    public List<Record> list(int cid) {
        List<Record> records = new ArrayList<Record>();
  
        String sql = "select * from record where cid = ?";
  
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                Record record = new Record();
                int id = rs.getInt("id");
                int spend = rs.getInt("spend");
                String comment = rs.getString("comment_");
                Date date = rs.getDate("date_");
                  
                record.spend=spend;
                record.cid=cid;
                record.comment=comment;
                record.date=date;
                record.id = id;
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return records;
    }    
     
    
    /**
     * 获取今天的消费记录信息
     * @return
     */
    public List<Record> listToday(){
        return list(DateUtil.today());
    }
     
    
    /**
     * 获取某天的消费记录信息
     * @param day
     * @return
     */
    public List<Record> list(Date day) {
        List<Record> records = new ArrayList<Record>();
        
        String sql = "select * from record where date_ =?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setDate(1, DateUtil.util2sql(day));
 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                int id = rs.getInt("id");
                int cid = rs.getInt("cid");
                int spend = rs.getInt("spend");
                String comment = rs.getString("comment_");
                Date date = rs.getDate("date_");
                  
                record.spend=spend;
                record.cid=cid;
                record.comment=comment;
                record.date=date;
                record.id = id;
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return records;
    }            
     
    
    /**
     * 获取本月的消费记录信息
     * @return
     */
    public List<Record> listThisMonth(){
        return list(DateUtil.monthBegin(),DateUtil.monthEnd());
    }
     
    
    /**
     * 获取某个时间范围内的消费记录信息
     * @param start
     * @param end
     * @return
     */
    public List<Record> list(Date start, Date end) {
        List<Record> records = new ArrayList<Record>();
        
        String sql = "select * from record where date_ >= ? and date_ <= ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setDate(1, DateUtil.util2sql(start));
            ps.setDate(2, DateUtil.util2sql(end));
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                int id = rs.getInt("id");
                int cid = rs.getInt("cid");
                int spend = rs.getInt("spend");
                String comment = rs.getString("comment_");
                Date date = rs.getDate("date_");
                  
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;
                record.id = id;
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return records;
    }
    
    
    /**
     * 统计总数
     * @return
     */
    public int getTotal() {
        int total = 0;
        
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from record";
  
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