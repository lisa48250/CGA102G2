package p.com.product.model;

import p.com.productcategory.model.Product_category_VO;

public class Product_VO {
	private Integer product_id;
	private Integer product_category_id;
	private String product_describtion;
	private Integer product_price;
	private String product_name;
	private Integer product_quantity;
	private Boolean product_status;
//	private String product

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getProduct_category_id() {
		return product_category_id;
	}

	public void setProduct_category_id(Integer product_category_id) {
		this.product_category_id = product_category_id;
	}

	public String getProduct_describtion() {
		return product_describtion;
	}

	public void setProduct_describtion(String product_describtion) {
		this.product_describtion = product_describtion;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Boolean getProduct_status() {
		return product_status;
	}

	public void setProduct_status(Boolean product_status) {
		this.product_status = product_status;
	}
	
	public p.com.productcategory.model.Product_category_VO getCategory_VO() {
		p.com.productcategory.model.Product_category_Service product_Category_Service = new p.com.productcategory.model.Product_category_Service();
		p.com.productcategory.model.Product_category_VO prodcat_category_VO = product_Category_Service.getOneProductByPrimarykey(product_category_id);
		return prodcat_category_VO;
	}
	
	public String getProduct_name(Integer product_id) {
		return product_name;
	}
	
	public Integer getProduct_price(Integer product_id) {
		return product_price;
	}


}
