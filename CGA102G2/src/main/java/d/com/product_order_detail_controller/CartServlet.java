package d.com.product_order_detail_controller;

import com.members.model.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import d.com.product.model.ProdVO;
import d.com.product.model.Product_Service;
import d.com.product.model.Product_VO;
import d.com.product_order_detail.model.*;
import d.com.product_order_list.model.PolService;
import d.com.product_order_list.model.PolVO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		HttpSession session;
		
		String action = req.getParameter("action");
		
		if ("buy_now".equals(action)) {
			
//			if ("加入購物車".equals(req.getParameter("goCar"))) {
				
				Product_VO poVO = new Product_VO();

				Integer product_id = Integer.valueOf(req.getParameter("productId"));
				String product_describtion = (req.getParameter("product_describtion"));
				Integer product_price = Integer.valueOf(req.getParameter("product_price"));
				String product_name = (req.getParameter("product_name"));
				Integer amounts = Integer.valueOf(req.getParameter("product_amount"));
				System.out.println(product_id);
				System.out.println(product_describtion);
				System.out.println(product_price);
				System.out.println(product_name);
				System.out.println(amounts);
				poVO.setProduct_id(product_id);
				poVO.setProduct_describtion(product_describtion);
				poVO.setProduct_price(product_price);
				poVO.setProduct_name(product_name);
				poVO.setProduct_quantity(amounts);

				session = req.getSession();
				Object buyList = session.getAttribute("shoppingcart");
				List<Product_VO> shoppingcart;
				if (buyList == null) {
					shoppingcart = new Vector<Product_VO>();
				} else {
					shoppingcart = (List<Product_VO>) buyList;
				}
				shoppingcart.add(poVO); // 將該物品加入購物車

				session.setAttribute("shoppingcart", shoppingcart);

				System.out.println("成功轉出");
				req.getRequestDispatcher("/front_end/purchasehomepage/PurchaseHomePage.jsp").forward(req, res);

//				

//			}

		}
		
//		if ("購物車結帳".equals(action)) {
//			session = req.getSession();
//			MemberVO member = (MemberVO) session.getAttribute("memberVO");
//			Integer memberID = member.getMember_id();
//			System.out.println(member.getMember_id());
//			req.setAttribute("memberID", memberID);
//			RequestDispatcher rd = req.getRequestDispatcher("/front_end/purchasehomepage/Cart_payment.jsp");
//			rd.forward(req, res);
//
//		}
////		===========購物車結帳+產生訂單============
//		if ("來自購物車信用卡付款".equals(action)) {
//			
//			session = req.getSession();
//			List<Product_VO> shoppingcart = (List<Product_VO>) session.getAttribute("shoppingcart");
////			List<Product_VO> shoppingcart;
//			Product_order_detailVO podVO = new Product_order_detailVO();
//			Product_order_detailService podsvc = new Product_order_detailService();
//
//			MemberVO member = (MemberVO) session.getAttribute("memberVO");
//			
//			for (Product_VO povo : shoppingcart) {
//				podVO.setMember_id(member.getMember_id()); // 這裡需session
//				podVO.setProduct_amount(povo.getProduct_quantity());
//				podVO.setProduct_id(povo.getProduct_id());
//				podVO.setOrder_status(0); // 信用卡
//				podVO.setPayment_method(0); // 已結帳
//
////				polVOlist = new ArrayList<PolVO>();
//				List<PolVO> polVOlist = new ArrayList<PolVO>();
//				PolVO polVO = new PolVO(); // 訂單明細
//				polVO.setOrder_quantity(povo.getProduct_quantity());
//				polVO.setProduct_id(povo.getProduct_id());
//				polVOlist.add(polVO);
//				podsvc.insertToPol(podVO, polVOlist);
//
//			}
//			String url = "/front_end/OrderSuccess/OrderSuccess.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
//
//		}
//		
	}

}
