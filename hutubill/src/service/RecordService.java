package service;
 
import java.util.Date;
 
import dao.RecordDAO;
import entity.Category;
import entity.Record;
 
/**
 * Record类业务层
 * @author OCEAN
 *
 */
public class RecordService {
    RecordDAO recordDao = new RecordDAO();
    
    
    /**
     * 根据消费金额、消费分类、备注和日期添加一条消费记录
     * @param spend
     * @param c
     * @param comment
     * @param date
     */
    public void add(int spend, Category c, String comment,Date date){
        Record r = new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;
        recordDao.add(r);
    }
}