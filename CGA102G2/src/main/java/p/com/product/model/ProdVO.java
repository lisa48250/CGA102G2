package p.com.product.model;

public class ProdVO {
	private Integer product_id;
//	private Integer product_category_id;
//	private String product_describtion;
	private Integer product_price;
	private String product_name;
//	private Integer product_quantity;
//	private Boolean product_status;

//	private Integer product_photo_id;
	private byte[] product_photo;
	private String productPhotoStr;

	private String product_category_name;
//	private String product_category_detail;
	
	private Integer product_amount;
	
	public ProdVO() {}


	
	
	
	public ProdVO(ProdVO.Builder builder) {
		product_id = builder.product_id;
		product_price = builder.product_price;
		product_name = builder.product_name;
		product_photo = builder.product_photo;
		productPhotoStr = builder.productPhotoStr;
		product_category_name = builder.product_category_name;		
		product_amount = builder.product_amount;
	}
	
	public static class Builder {
		private Integer product_id = 0;
		private Integer product_price = 0;
		private String product_name = "";
		private byte[] product_photo = {};
		private String productPhotoStr = "";
		private String product_category_name = "";		
		private Integer product_amount = 0;
		
		public ProdVO.Builder setProduct_amount(Integer product_amount) {
			this.product_amount = product_amount;
			return this;
		}
		
		public ProdVO.Builder setProductPhotoStr(String productPhotoStr) {
			this.productPhotoStr = productPhotoStr;
			return this;			
		}
		
		public ProdVO.Builder setProduct_id(Integer product_id) {
			this.product_id = product_id;
			return this;
		}
		
		public ProdVO.Builder setProduct_price(Integer product_price) {
			this.product_price = product_price;
			return this;
		}
		
		public ProdVO.Builder setProduct_name(String product_name) {
			this.product_name = product_name;
			return this;
		}
		
		public ProdVO.Builder setProduct_photo(byte[] product_photo) {
			this.product_photo = product_photo;
			return this;
		}
		
		public ProdVO.Builder setProduct_category_name(String product_category_name) {
			this.product_category_name = product_category_name;
			return this;
		}
	}

	public Integer getProduct_amount() {
		return product_amount;
	}

	public void setProduct_amount(Integer product_amount) {
		this.product_amount = product_amount;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public String getProductPhotoStr() {
		return productPhotoStr;
	}

	public void setProductPhotoStr(String productPhotoStr) {
		this.productPhotoStr = productPhotoStr;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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
	

}
