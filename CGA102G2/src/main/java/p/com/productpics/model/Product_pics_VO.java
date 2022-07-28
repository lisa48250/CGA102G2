package p.com.productpics.model;

import p.com.product.model.Product_Service;
import p.com.product.model.Product_VO;

public class Product_pics_VO {
	private Integer product_id;
	private Integer product_photo_id;
	private byte[] product_photo;
//	private String product_name;
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getProduct_photo_id() {
		return product_photo_id;
	}
	public void setProduct_photo_id(Integer product_photo_id) {
		this.product_photo_id = product_photo_id;
	}
	public byte[] getProduct_photo() {
		return product_photo;
	}
	public void setProduct_photo(byte[] product_photo) {
		this.product_photo = product_photo;
	}
	

	public Product_VO getProduct_VO() {
		Product_Service dao = new Product_Service();
		return dao.getOneProduct(product_id);
			
	}

}
