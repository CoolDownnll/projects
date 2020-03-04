package entity;

 /**
  * 分类信息类
  * @author OCEAN
  *
  */
public class Category {
    public int id;
    public String name;
     
    public int recordNumber;// 此字段是根据record表查出来的，所以该字段不放到数据库中
     
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRecordNumber() {
        return recordNumber;
    }
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    
    /**
     * 在后续JComboBox中显示的时候，会调用此方法，用于显示分类名称
     */
    public String toString(){
        return name;
    }
}