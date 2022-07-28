package d.com.car_product_category.model;

import java.util.List;



public interface CarpdDAO_interface {
	 public void insert(CarpdVO car);
     public void update(Integer product_id, Integer member_id, Integer qauntity);
     public void delete(Integer product_id, Integer member_id);
     public void deleteAll(Integer member_id);
     public CarpdVO findByPrimaryKey(Integer product_id,Integer member_id);
     public List<CarpdVO> getAll();
     public List<CarpdVO> getMembersCar(Integer member_id);
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<EmpVO> getAll(Map<String, String[]> map); 

}
