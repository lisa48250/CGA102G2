package d.com.car_product_category.model;

import java.util.List;

import d.com.product.model.Product_VO;

public class CarpdService {
	private CarpdDAO_interface dao;
	
	
	public CarpdService() {
		dao = new CarpdJDBCDAO(); 
	}
	
	public void addOneCar(CarpdVO car) {
		CarpdVO carVo = new CarpdVO();
		dao.insert(carVo);
		
	} 
	
	public void updateOneCar(Integer product_id, Integer member_id, Integer qauntity) {
		dao.update(product_id, member_id, qauntity);
	}
	
	public void deleteOneCar(Integer product_id, Integer member_id) {
		dao.delete(product_id, member_id);
	}
	
	public void deleteAllCar(Integer member_id) {
		dao.deleteAll(member_id);
	}
	
	public CarpdVO getOneCarVO(Integer product_id, Integer member_id) {
		return dao.findByPrimaryKey(product_id, member_id);
	}
	
	public List<CarpdVO> getAll(){
		return dao.getAll();
	}
	
	public List<CarpdVO> getMembersCar(Integer member_id){
		return dao.getMembersCar(member_id);
	}
	
	
}
