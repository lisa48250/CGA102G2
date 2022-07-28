package d.com.product.model_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import d.com.product.model.ProdService;
import d.com.product.model.ProdVO;
import d.com.product.model.Product_Service;
import d.com.product.model.Product_VO;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/prodServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson;   
    private ProdService prodSvc;
    public ProdServlet() {
    	gson = new Gson();

    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	doPost(request, response);

	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");
//		String action = req.getParameter("action");
		List<ProdVO> list = null; 
		prodSvc = new ProdService();
		list = prodSvc.getAllProd();
		res.getWriter().append(gson.toJson(list));
    	
	}

}
