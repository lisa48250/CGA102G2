package d.com.product_order_list.model;

public class PolVO {
	private Integer product_order_id;
	private Integer product_id;
	private Integer order_quantity;

	public Integer getProduct_order_id() {
		return product_order_id;
	}

	public void setProduct_order_id(Integer product_order_id) {
		this.product_order_id = product_order_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Integer order_quantity) {
		this.order_quantity = order_quantity;
	}

	@Override
	public String toString() {
		return "product_order_id: " + product_order_id + "\n" + "product_id: " + product_id + "\n" + "order_quantity: "
				+ order_quantity;

	}

}
