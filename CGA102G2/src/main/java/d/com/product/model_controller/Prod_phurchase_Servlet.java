package d.com.product.model_controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import d.com.product.model.ProdVO;
import d.com.product.model.Product_VO;



@WebServlet("/Prod_phurchase_Servlet")
public class Prod_phurchase_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		
		Integer product_id = Integer.valueOf(req.getParameter("product_id"));
		String product_name = req.getParameter("product_name");
		Integer product_price = Integer.valueOf(req.getParameter("product_price"));
		
		String product_describtion = req.getParameter("product_describtion"); 
//		String product_detail = req.getParameter("product_detail");
		Product_VO prodVO = new Product_VO();
		prodVO.setProduct_id(product_id);
		prodVO.setProduct_name(product_name);
		prodVO.setProduct_price(product_price);
		prodVO.setProduct_describtion(product_describtion);
		System.out.println("product_id:" + product_id);
		System.out.println("product_name:" + product_name);
		System.out.println("product_price:" + product_price);
		
		System.out.println("product_detail:" + product_describtion);
		req.setAttribute("prodVO", prodVO);
		
		String url = "/front_end/purchasehomepage/Show_productpage0.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
		
//		Integer product_id = Integer.valueOf(req.getParameter("product_id"));
//		String product_name = req.getParameter("product_name");
//		Integer product_amount = Integer.valueOf(req.getParameter("product_amount"));

	}

}
