package d.com.product_order_list.model;

import java.util.List;



public interface PolDAO_interface {
	 public void insert(PolVO order_list);
     public void update(Integer product_order_id, Integer qauntity);
//     public void delete(Integer product_order_id);
     public void delete(Integer proudct_order_id);
     public PolVO findByPrimaryKey(Integer product_order_id);
     public List<PolVO> getAll();
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<EmpVO> getAll(Map<String, String[]> map); 
     public void insertForPodVO(PolVO polVO, java.sql.Connection con);
}
