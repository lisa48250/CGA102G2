package p.com.productcategory.model;

import java.util.List;

//import project.category.vo.Product_categoryVO;

public interface Product_category_DAO_interface {
	public void insert(Product_category_VO product_categoryVO);
	public void update(Product_category_VO product_categoryVO);
	public void delete(Integer product_category_id);
	public Product_category_VO findByPrimarykey(Integer product_category_id);
//	public Product_categoryVO findByName(String product_category_name);
	
	
	public List<Product_category_VO> getAll();

}
