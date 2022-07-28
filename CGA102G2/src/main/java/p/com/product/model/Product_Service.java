package p.com.product.model;

import java.util.List;

public class Product_Service {
	private Product_DAO_interface dao;
	public Product_Service() {
//		dao = new ProductJDBCDAO();
		dao = new Product_DAO();
	}

	public List<Product_VO> getAll() {
		return dao.getAll();
	}
	
	public List<ProductVO> getAllProductSales() {
		return dao.fineAllDataSales();
	}
	 
	public Product_VO addOneProduct(Integer product_category_id, String product_describtion, Integer product_price, String product_name, Integer product_quantity, Boolean product_status) {
		Product_VO productVO = new Product_VO();
		productVO.setProduct_category_id(product_category_id);
		productVO.setProduct_describtion(product_describtion);
//		productVO.setProduct_id(product_id);
		productVO.setProduct_name(product_name);
		productVO.setProduct_price(product_price);
		productVO.setProduct_quantity(product_quantity);
		productVO.setProduct_status(product_status);
		dao.insert(productVO);
		
		return productVO;
	}
	
	// 預留
	public void addOneProduct(Product_VO productVO) {
		dao.insert(productVO);
	}
// -----------------------------------
	public Product_VO getOneProduct(Integer product_id) {
		return dao.findByPrimarykey(product_id);
	}
// -----------------------------------------------	
	public Product_VO updateProduct(Integer product_id, Integer product_category_id, String product_describtion, Integer product_price, String product_name, Integer product_quantity, Boolean product_status) {
		Product_VO productVO = new Product_VO();
		productVO.setProduct_id(product_id);
		productVO.setProduct_category_id(product_category_id);
		productVO.setProduct_describtion(product_describtion);
		productVO.setProduct_id(product_id);
		productVO.setProduct_name(product_name);
		productVO.setProduct_price(product_price);
		productVO.setProduct_quantity(product_quantity);
		productVO.setProduct_status(product_status);
		
		dao.update(productVO);
		return productVO;
	}

	public void updateProduct(Product_VO productVO) {
		dao.update(productVO);
	}

	// 未測
//	public Set<Product_VO> getEmpsByProduct(Integer product_id) {
//		return dao.getEmpsByDeptno(product_id);
//	}

	public void deleteProduct(Integer product_id) {
		dao.delete(product_id);
	}

	public Product_VO getOneProductByName(String product_name) {
		return dao.findByProductName(product_name);
	}
	
	// 模糊比對
	public List<ProductVO> getProdByLikeName(String product_name) {
		return dao.findByLikeProductName(product_name);
	}
	
	public List<ProductVO> getProductByCategoryId(Integer product_category_id) {
		
		return dao.getAllProductsCateGoryId(product_category_id);
	}

}
