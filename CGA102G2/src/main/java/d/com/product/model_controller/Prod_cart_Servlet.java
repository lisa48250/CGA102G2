package d.com.product.model_controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import d.com.product.model.ProdVO;

/**
 * Servlet implementation class Prod_cart_Servlet
 */
@WebServlet("/Prod_cart_Servlet")
public class Prod_cart_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Prod_cart_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
//		String action = req.getParameter("action");
		String actionA = req.getParameter("actionA");
//		String pay = req.getParameter("payNow");
//		String car = req.getParameter("goCar");
		
System.out.println(actionA + "0");
//System.out.println(pay + "1");
//System.out.println(pay + "1");
		if("buy_now".equals(actionA)) {
//			Integer product_id = Integer.valueOf(req.getParameter("product_id"));
//			String product_name = req.getParameter("product_name");
//			Integer product_amount = Integer.valueOf(req.getParameter("product_amount"));
System.out.println(actionA + "1");			
			
			Integer product_id = Integer.valueOf(req.getParameter("product_id"));
			String product_name = req.getParameter("product_name");
			Integer product_price = Integer.valueOf(req.getParameter("product_price"));
			Integer product_amount = Integer.valueOf(req.getParameter("product_amount"));
			
			
			System.out.println(req.getParameter("product_id") + "  ,ID");
			System.out.println(req.getParameter("product_name") + " ,NAME");
			System.out.println(req.getParameter("product_price") + " ,PRICE");
			System.out.println("product_number:" + product_amount);
			
//			Integer product_amount = Integer.valueOf(req.getParameter("input-amounts"));
			
//			Integer product_num = Integer.valueOf(req.getParameter("input-amounts"));
			
//			System.out.println(req.getParameter("input-amounts") + " ,NUMBER");
			
			HttpSession session = req.getSession();
			Object buyList = session.getAttribute("shoppingcart");
			List<ProdVO> shoppingcart;
			if(buyList == null) {
				shoppingcart =  new Vector<ProdVO>();
			} else {
				shoppingcart = (List<ProdVO>) buyList;
			}
			
			
			
						
			ProdVO prodVO = new ProdVO();
//			prodVO.setProduct_price(199);
			prodVO.setProduct_amount(product_amount);
			prodVO.setProduct_id(product_id);
			prodVO.setProduct_price(product_price);
			prodVO.setProduct_name(product_name);
			
			
			shoppingcart.add(prodVO);
//			HttpSession session = req.getSession();
			session.setAttribute("shoppingcart", shoppingcart);		
			String url = "/front_end/purchasehomepage/Cart.jsp";
			req.getRequestDispatcher(url).forward(req, resp);	
//			我只要這以上，下面不要

		}
		
		if("goCar".equals(actionA)) {
//			Integer product_id = Integer.valueOf(req.getParameter("product_id"));
//			String product_name = req.getParameter("product_name");
//			Integer product_amount = Integer.valueOf(req.getParameter("product_amount"));
System.out.println(actionA + "2");			
			
			Integer product_id = Integer.valueOf(req.getParameter("product_id"));
			String product_name = req.getParameter("product_name");
			Integer product_price = Integer.valueOf(req.getParameter("product_price"));
			Integer product_amount = Integer.valueOf(req.getParameter("product_amount"));
			
			
			System.out.println(req.getParameter("product_id") + "  ,ID");
			System.out.println(req.getParameter("product_name") + " ,NAME");
			System.out.println(req.getParameter("product_price") + " ,PRICE");
			System.out.println("product_number:" + product_amount);
			
//			Integer product_amount = Integer.valueOf(req.getParameter("input-amounts"));
			
//			Integer product_num = Integer.valueOf(req.getParameter("input-amounts"));
			
//			System.out.println(req.getParameter("input-amounts") + " ,NUMBER");
			
			
			HttpSession session = req.getSession();
			Object buyList = session.getAttribute("shoppingcart");
			List<ProdVO> shoppingcart;
			if(buyList == null) {
				shoppingcart =  new Vector<ProdVO>();
			} else {
				shoppingcart = (List<ProdVO>) buyList;
			}
			
			
//			List<ProdVO> shoppingcart =  new Vector<ProdVO>();			
			ProdVO prodVO = new ProdVO();
//			prodVO.setProduct_price(199);
			prodVO.setProduct_amount(product_amount);
			prodVO.setProduct_id(product_id);
			prodVO.setProduct_price(product_price);
			prodVO.setProduct_name(product_name);
			
			
			shoppingcart.add(prodVO);
//			HttpSession session = req.getSession();
			session.setAttribute("shoppingcart", shoppingcart);		
			
//			String url = "/front_end/product/Cart.jsp";
			String url = "/front_end/purchasehomepage/Purchase_HomePage.jsp";
			req.getRequestDispatcher(url).forward(req, resp);	

		}

	}
}
