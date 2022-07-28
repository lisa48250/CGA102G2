package p.com.productpics.model;

import java.util.List;

public class Product_pics_Service {
	private Product_pics_DAO dao;

	public Product_pics_Service() {
		dao = new Product_pics_DAO();
	}

	public List<Product_pics_VO> getAll() {
		return dao.getAll();
	}
	
	public List<Product_pics_VO> getProductPics(Integer product_id) {
		return dao.findByProductID(product_id);
	}

	public Product_pics_VO addOneProductPics(Integer procuct_id, byte[] product_photo) {
		Product_pics_VO product_picsVO = new Product_pics_VO();
		product_picsVO.setProduct_id(procuct_id);
		product_picsVO.setProduct_photo(product_photo);

		dao.insert(product_picsVO);

		return product_picsVO;
	}
	
	
	public void addOneProductPics(Product_pics_VO product_picsVO) {
		dao.insert(product_picsVO);
	}
// -----------------------------------
	public Product_pics_VO updateProductPics(Integer product_photo_id, Integer product_id, byte[] product_photo) {
		Product_pics_VO product_picsVO = new Product_pics_VO();
		product_picsVO.setProduct_photo_id(product_photo_id);
		product_picsVO.setProduct_id(product_id);
		product_picsVO.setProduct_photo(product_photo);
//		product_picsVO.setProduct_category_detail(product_category_describtion);		
		
		dao.update(product_picsVO);
		return product_picsVO;
	}

	public void updateProductPics(Product_pics_VO product_picsVO) {
		dao.update(product_picsVO);
	}
	
	public void deleteProductPics(Integer product_photo_id) {
		dao.delete(product_photo_id);
	}
	
	public Product_pics_VO getOnePicByPrimarykey(Integer product_photo_id) {
		return dao.findByPrimarykey(product_photo_id);
	}
//	public Product_categoryVO getOneProductByName(String product_category_name) {
//		return dao.findByPrimarykey(product_category_name);
//	}

}
