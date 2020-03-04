package util;
 
import java.util.Calendar;
import java.util.Date;
 
/**
 * 日期工具类：消费一览中的获取今日的消费总额、本月的消费总额、今天距离月末还有多长时间等功能
 * @author OCEAN
 *
 */
public class DateUtil {
    static long millisecondsOfOneDay = 24*60*60*1000;   
 
    
    /**
     * 日期类型转换：java.util.Date(通过日期控件获取到的日期类型)----->java.sql.Date
     * @param d
     * @return
     */
    public static java.sql.Date util2sql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }
     
    
    /**
     * 获取今天，并且把时分秒和毫秒都置0：因为通过日期控件获取到的日期是没有时分秒和毫秒的
     * @return
     */
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        
        return c.getTime();
    }
 
    
    /**
     * 使用Calendar获取本月第一天： 消费一览中的本月消费功能，其实就是从数据库中把本月第一天到最后一天的数据查出来，再进行简单统计
     * @return
     */
    public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
         
        return c.getTime();
    }
    /**
     * 使用Calendar获取本月第一天：同上
     * @return
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONDAY, 1);
        c.add(Calendar.DATE, -1);
        
        return c.getTime();
    }
 
    
    /**
     * 获取本月一共有多少天
     * @return
     */
    public static int thisMonthTotalDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();
 
        return (int)((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay) +1;
    }
     
    
    /**
     * 获取本月还剩多少天
     * @return
     */
    public static int thisMonthLeftDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        
        return (int) ((lastDayMilliSeconds-toDayMilliSeconds)/millisecondsOfOneDay) +1;
    }   
    
}