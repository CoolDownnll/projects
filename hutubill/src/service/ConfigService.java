package service;
 
import dao.ConfigDAO;
import entity.Config;
 
/**
 * Config类业务层
 * @author OCEAN
 *
 */
public class ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";
 
    static ConfigDAO dao = new ConfigDAO();
    
    static{
        init();
    }
 
    
    /**
     * 初始化预算和Mysql路径
     */
    public static void init(){
        init(budget, default_budget);
        init(mysqlPath, "");
    }
    
    private static void init(String key, String value) {
        Config config= dao.getByKey(key);
        
        if(config == null){
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
    }
 
    
    /**
     * 数据库中的budget是String类型，所以需要转成int型
     * @return
     */
    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }
    
    /**
     * 根据键获取相应的值
     * @param key
     * @return
     */
    public String get(String key) {
        Config config= dao.getByKey(key);
        return config.getValue();
    }
     
    
    /**
     * 更新键对应的值
     * @param key
     * @param value
     */
    public void update(String key, String value){
        Config config= dao.getByKey(key);
        config.setValue(value);
        dao.update(config);     
    }
     
}