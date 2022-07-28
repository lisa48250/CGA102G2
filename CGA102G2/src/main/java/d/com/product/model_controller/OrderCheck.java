package d.com.product.model_controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import d.com.product.model.Product_VO;
import d.com.product_order_list.model.PolVO;

@WebServlet("/OrderCheck")
public class OrderCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = null;
	Product_VO prod_vo = null;

	public OrderCheck() {
		gson = new Gson();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PolVO[] orderArray = gson.fromJson(req.getReader(), PolVO[].class);
		List<PolVO> list = Arrays.asList(orderArray);
		System.out.println(list);
		for (int i=0; i<list.size(); i++) {
			System.out.print("第" + (i+1) + "項：商品編號" + list.get(i).getProduct_id() + ", ");
			System.out.println("商品數量" + list.get(i).getOrder_quantity());
			
		}
		
	}
}
