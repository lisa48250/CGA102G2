package p.com.productcategory.model;

import java.util.List;

//import com.product.model.ProductVO;

public class Product_category_Service {
	private Product_category_DAO_interface dao;
	public Product_category_Service() {
//		dao = new ProductJDBCDAO();
		dao = new Product_category_DAO();
	}
	
	public List<Product_category_VO> getAll() {
		return dao.getAll();
	}	
	
	public Product_category_VO addOneProductCategory(String product_category_name, String product_category_describtion) {
		//(Integer product_category_id, String product_category_name, String product_category_describtion) {
			Product_category_VO product_categoryVO = new Product_category_VO();
			product_categoryVO.setProduct_category_name(product_category_name);
			product_categoryVO.setProduct_category_detail(product_category_describtion);

		dao.insert(product_categoryVO);
		
		return product_categoryVO;
	}
	

	public void addOneProductCategory(Product_category_VO product_categoryVO) {
		dao.insert(product_categoryVO);
	}
// -----------------------------------
	public Product_category_VO updateProduct_categoryVO(Integer product_category_id, String product_category_name, String product_category_describtion) {
		Product_category_VO product_categoryVO = new Product_category_VO();
		product_categoryVO.setProduct_category_id(product_category_id);
		product_categoryVO.setProduct_category_name(product_category_name);
		product_categoryVO.setProduct_category_detail(product_category_describtion);		
		
		dao.update(product_categoryVO);
		return product_categoryVO;
	}

	public void updateProduct(Product_category_VO product_categoryVO) {
		dao.update(product_categoryVO);
	}
	
	public void deleteProduct(Integer product_category_id) {
		dao.delete(product_category_id);
	}
	
	public Product_category_VO getOneProductByPrimarykey(Integer product_category_id) {
		return dao.findByPrimarykey(product_category_id);
	}
//	public Product_categoryVO getOneProductByName(String product_category_name) {
//		return dao.findByPrimarykey(product_category_name);
//	}

}
