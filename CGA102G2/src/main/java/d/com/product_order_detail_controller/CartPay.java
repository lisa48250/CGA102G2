package d.com.product_order_detail_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.members.model.MemberVO;

/**
 * Servlet implementation class CartPay
 */
@WebServlet("/CartPay")
public class CartPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartPay() {
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
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		HttpSession session;

		String action = req.getParameter("action");
		if ("購物車結帳".equals(action)) {
			session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("memberVO");
			Integer memberID = member.getMember_id();
			System.out.println(member.getMember_id());
			req.setAttribute("memberID", memberID);
			RequestDispatcher rd = req.getRequestDispatcher("/front_end/purchasehomepage/Cart_payment.jsp");
			rd.forward(req, res);

		}
	}

}
