package p.com.product.model;

import java.util.List;

public interface Product_DAO_interface {
	public void insert(Product_VO productVO);
	public void update(Product_VO productVO);
	public void delete(Integer product_id);
	public Product_VO findByPrimarykey(Integer product_id);
	public List<Product_VO> getAll();
	
	public Product_VO findByProductName(String product_name);
	public List<ProductVO> findByLikeProductName(String product_name);
	public List<ProductVO> getAllProductsCateGoryId(Integer product_cateGory_id);
	
	public List<ProductVO> fineAllDataSales();// 未測試
	
	

}

//Integer product_id, Integer product_category_id, String product_describtion, Integer product_price, String product_name, Integer product_quantity, Boolean product_status