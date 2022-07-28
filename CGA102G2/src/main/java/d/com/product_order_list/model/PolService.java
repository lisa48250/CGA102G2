package d.com.product_order_list.model;

import java.util.List;

public class PolService {
	PolDAO_interface dao;
	
	public PolService(){
		dao = new PolJDBCDAO();
	}
	
	public PolVO getOnePol(Integer product_order_id) {
		return dao.findByPrimaryKey(product_order_id);
		
	}
	
	public List<PolVO> getAllPol(){
		return dao.getAll();
	}
	
	public void delete(Integer proudct_order_id) {
		 dao.delete(proudct_order_id);
	}
	
	
}
