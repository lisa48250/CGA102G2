package p.com.product.model;

public class ProductVO {
	
	private Integer product_id;
	private Integer product_category_id;
	private String product_describtion;
	private Integer product_price;
	private String product_name;
	private Integer product_quantity;
	private Boolean product_status;


	private byte[] product_photo;
//	private String productPhotoStr;

	private String product_category_name;
	private String product_category_detail;
	
	
	public ProductVO() {
	}


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


	public byte[] getProduct_photo() {
		return product_photo;
	}


	public void setProduct_photo(byte[] product_photo) {
		this.product_photo = product_photo;
	}


	public String getProduct_category_name() {
		return product_category_name;
	}


	public void setProduct_category_name(String product_category_name) {
		this.product_category_name = product_category_name;
	}


	public String getProduct_category_detail() {
		return product_category_detail;
	}


	public void setProduct_category_detail(String product_category_detail) {
		this.product_category_detail = product_category_detail;
	}
}
