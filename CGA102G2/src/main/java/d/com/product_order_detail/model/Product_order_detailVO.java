package d.com.product_order_detail.model;


import java.sql.Date;
import java.util.List;

import com.members.model.MemberService;
import com.members.model.MemberVO;

import d.com.car_product_category.model.CarpdService;
import d.com.car_product_category.model.CarpdVO;

public class Product_order_detailVO {
	private Integer product_order_id;
	private Integer member_id;
	private Integer product_id;
	private Date product_order_date;
	private Integer product_amount;
	private Integer payment_method;
	private Integer order_status;
	private MemberVO memberVO;
	public Integer getProduct_order_id() {
		return product_order_id;
	}
	public void setProduct_order_id(Integer product_order_id) {
		this.product_order_id = product_order_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Date getProduct_order_date() {
		return product_order_date;
	}
	public void setProduct_order_date(Date product_order_date) {
		this.product_order_date = product_order_date;
	}
	public Integer getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(Integer product_amout) {
		this.product_amount = product_amout;
	}
	public Integer getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(Integer payment_method) {
		this.payment_method = payment_method;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	} 
	
	
//	join Member
	public MemberVO getMemberVO() {
		MemberService memsvc = new MemberService();
		memberVO = memsvc.getOneMember(member_id);
		return memberVO;
	}
	
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	
	@Override
	public String toString() {
		
		return 
				"product_order_id: " + product_order_id + "\n" 
				+ "member_id: " + member_id + "\n" 
				+ "product_order_date: " + product_order_date + "\n"
				+ "product_amount: " + product_amount + "\n"
				+ "payment_method: " + payment_method + "\n"
				+ "order_status: " + order_status;
				
	}
}
