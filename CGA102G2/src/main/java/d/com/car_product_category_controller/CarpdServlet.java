package d.com.car_product_category_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import d.com.car_product_category.model.CarpdService;
import d.com.car_product_category.model.CarpdVO;

/**
 * Servlet implementation class CarpdServlet
 */
@WebServlet("/CarpdServlet")
public class CarpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CarpdServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		String action = req.getParameter("action");
		
		// 取得該會員所有購物車商品內容
		if("getOne_memberId_car_list".equals(action)) {
			Integer member_id = Integer.valueOf(req.getParameter("memberId"));
			CarpdService carsvc = new CarpdService();
			List<CarpdVO> carList = carsvc.getMembersCar(member_id);
//			System.out.println(carList);

//			包裝送出
			req.setAttribute("carList", carList);
			String url = "/purchase_car/Carhomepage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
			
		}
		
		//刪除該會員的 單筆購物車商品
		if("delete".equals(action)) {
			Integer carVO_product_id = Integer.valueOf(req.getParameter("carVO_product_id"));
			Integer carVO_member_id = Integer.valueOf(req.getParameter("carVO_member_id"));
			// delete
			CarpdService carsvc = new CarpdService();
			carsvc.deleteOneCar(carVO_product_id, carVO_member_id);
			// forward
			List<CarpdVO> carList =  carsvc.getMembersCar(carVO_member_id);
			
			String url = "/purchase_car/Carhomepage.jsp";
			req.setAttribute("carList", carList);
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
			
			
			
			
			
			
			
			
			
		}
		
	}

}
