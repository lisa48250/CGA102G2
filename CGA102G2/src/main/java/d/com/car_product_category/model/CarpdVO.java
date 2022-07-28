package d.com.car_product_category.model;

import d.com.product.model.Product_Service;
import d.com.product.model.Product_VO;

public class CarpdVO {
	private Integer product_id;
	private Integer member_id;
	private String product_name;
	private Integer quantity;
	private Product_VO poVo;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

	@Override
	public String toString() {
		return "product_id: " + product_id + "\n" 
				+ "member_id: " + member_id + "\n" 
				+ "product_name: " + product_name + "\n"
				+ "quantity: " + quantity;
	}
	
	// join 商品
	public Product_VO getProductVo() {

		Product_Service posvc = new Product_Service();
		poVo = posvc.getOneProduct(product_id);
		return poVo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
