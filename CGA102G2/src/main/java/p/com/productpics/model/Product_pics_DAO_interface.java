package p.com.productpics.model;

import java.util.List;

//import project.pics.vo.Product_picsVO;

public interface Product_pics_DAO_interface {
	public void insert(Product_pics_VO product_picsVO);
	public void update(Product_pics_VO product_picsVO);
	public void delete(Integer product_photo_id);
	public Product_pics_VO findByPrimarykey(Integer product_photo_id);
	public List<Product_pics_VO> getAll();
	public List<Product_pics_VO> findByProductID(Integer product_id);

}
