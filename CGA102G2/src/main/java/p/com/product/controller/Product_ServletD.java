package p.com.product.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.com.product.model.ProductVO;
import p.com.product.model.Product_Service;
import p.com.product.model.Product_VO;



@WebServlet("/product.do")
public class Product_ServletD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Product_Service ProdSvc = new Product_Service();

       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");		
		
		//
		if ("getOne_For_Display".equals(action)) { 

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("product_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.put("product_id","請輸入商品編號");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product/Select_page.jsp");
					failureView.forward(req, res);// /back_end/product
					return;
				}
				
				Integer product_id = null;
				try {
					product_id = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.put("product_id","商品編號格式不正確");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product/Select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始查詢資料*****************************************/
				Product_Service prodSvc = new Product_Service();
				Product_VO productVO = prodSvc.getOneProduct(product_id);
				if (productVO == null) {
					errorMsgs.put("product_id","查無資料");
				}
				if (!errorMsgs.isEmpty()) {					
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product/Select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prodVO", productVO);
				String url = /*req.getContextPath() +*/ "/back_end/product/List_one_prod.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}		// if
		
		
		if ("getOne_For_Update".equals(action)) {

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer product_id = Integer.valueOf(req.getParameter("product_id"));
				
				/***************************2.開始查詢資料****************************************/
				Product_Service prodSvc = new Product_Service();
				Product_VO productVO = prodSvc.getOneProduct(product_id);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?product_id="  +productVO.getProduct_id()+
						       "&product_name="  +productVO.getProduct_name()+
						       "&product_category_id="    +productVO.getProduct_category_id()+
						       "&product_describtion="+productVO.getProduct_describtion()+
						       "&product_price="    +productVO.getProduct_price()+
						       "&product_quantity="   +productVO.getProduct_quantity()+
						       "&product_status=" +productVO.getProduct_status();
				
				String url = "/back_end/product/Update_product.jsp"+param;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
		
		if ("delete".equals(action)) {

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer product_id = Integer.valueOf(req.getParameter("product_id"));
				
				/***************************2.開始刪除資料***************************************/
				Product_Service prodSvc = new Product_Service();
				prodSvc.deleteProduct(product_id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back_end/product/List_all_prods.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
		if ("update".equals(action)) {
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer product_id = Integer.valueOf(req.getParameter("product_id").trim());
				
				String product_name = req.getParameter("product_name");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,30}$";
				if (product_name == null || product_name.trim().length() == 0) {
					errorMsgs.put("product_name","商品名稱請勿空白");
				} else if(!product_name.trim().matches(enameReg)) {
					errorMsgs.put("product_name","商品名稱只能是中、英文字母、數字和_ , 且長度必需在2到30之間");
	            }				
				
				String product_describtion = req.getParameter("product_describtion");
				enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,100}$";
				if (product_describtion == null || product_describtion.trim().length() == 0) {
					errorMsgs.put("product_describtion","商品介紹請勿空白");
				} else if(!product_name.trim().matches(enameReg)) {
					errorMsgs.put("product_describtion","商品介紹只能是中、英文字母、數字和_ , 且長度必需在2到100之間");
	            }
//				if (product_describtion == null || product_describtion.trim().length() == 0) {
//					errorMsgs.put("product_describtion","商品說明請勿空白");
//				}

				
				Integer product_price = null;
				try {
					product_price = Integer.valueOf(req.getParameter("product_price").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("product_price","售價請填數字");
				}

				
				Integer product_quantity = null;
				String product_quantitys = req.getParameter("product_quantity");
				if (product_quantitys == null || product_quantitys.trim().length() == 0) {
					errorMsgs.put("product_quantity","商品數量請勿空白");					
				} else {
					try {
						product_quantity = Integer.valueOf(req.getParameter("product_quantity").trim());
					} catch (NumberFormatException e) {
						errorMsgs.put("product_price","商品數量請填數字");
					}
				}
			
				
				Boolean product_status = null;
				product_status = Boolean.valueOf(req.getParameter("product_status"));

				
				Integer product_category_id = null;
				product_category_id = Integer.valueOf(req.getParameter("product_category_id"));


				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product/Update_product.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始修改資料*****************************************/
				Product_Service prodSvc = new Product_Service();
				Product_VO prodVO = new Product_VO();
				prodVO = prodSvc.updateProduct(product_id ,product_category_id, product_describtion, product_price, product_name, product_quantity, product_status);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prodVO", prodVO);
				String url = "/back_end/product/List_one_prod.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
		if ("insert".equals(action)) {
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				
				String product_name = req.getParameter("product_name");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,30}$";
				if (product_name == null || product_name.trim().length() == 0) {
					errorMsgs.put("product_name","商品名稱請勿空白");
				} else if(!product_name.trim().matches(enameReg)) {
					errorMsgs.put("product_name","商品名稱只能是中、英文字母、數字和_ , 且長度必需在2到30之間");
	            }
				
				
				String product_describtion = req.getParameter("product_describtion");
				enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,100}$";
				if (product_describtion == null || product_describtion.trim().length() == 0) {
					errorMsgs.put("product_describtion","商品介紹請勿空白");
				} else if(!product_name.trim().matches(enameReg)) {
					errorMsgs.put("product_describtion","商品介紹只能是中、英文字母、數字和_ , 且長度必需在2到100之間");
	            }
				
				
//				String product_describtion = req.getParameter("product_describtion");
//				if (product_describtion == null || product_describtion.trim().length() == 0) {
//					errorMsgs.put("product_describtion","商品說明請勿空白");
//				}

				Integer product_price = null;
				try {
					product_price = Integer.valueOf(req.getParameter("product_price").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("product_price","售價請填數字");
				}
//				prodVO.setProduct_price(product_price);
				
				
//				Integer product_quantity = null;
//				try {
//					product_quantity = Integer.valueOf(req.getParameter("product_quantity").trim());
//				} catch (NumberFormatException e) {
//					errorMsgs.put("product_price","商品數量請填數字");
//				}
				
				Integer product_quantity = null;
				try {
					product_quantity = Integer.valueOf(req.getParameter("product_quantity").trim());
				} catch (NumberFormatException e) {
					errorMsgs.put("product_quantity","數量請填數字");
				}
				
//				String product_quantitys = req.getParameter("product_quantity");
//				if (product_quantitys == null || product_quantitys.trim().length() == 0) {
//					errorMsgs.put("product_quantity","商品數量: 請勿空白");					
//				} else {
//					try {
//						product_quantity = Integer.valueOf(req.getParameter("product_quantity").trim());
//					} catch (NumberFormatException e) {
//						errorMsgs.put("product_price","商品數量請填數字");
//					}
//				}
//				try {
//					product_quantity = Integer.valueOf(req.getParameter("product_quantity").trim());
//				} catch (NumberFormatException e) {
//					errorMsgs.put("product_quantity","商品數量請填數字");
//				}
//				prodVO.setProduct_quantity(product_quantity);
				
				
				Boolean product_status = null;
				product_status = Boolean.valueOf(req.getParameter("product_status"));
				
				Integer product_category_id = null;
				product_category_id = Integer.valueOf(req.getParameter("product_category_id"));

				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product/Add_product.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Product_Service prodSvc = new Product_Service();
				Product_VO prodVO = new Product_VO();
				prodVO = prodSvc.addOneProduct(product_category_id, product_describtion, product_price, product_name, product_quantity, product_status);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prodVO", prodVO);
				String url = "/back_end/product/List_one_prod.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
		if("select_like_name".equals(action)) {
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String product_name = req.getParameter("product_name");
//System.out.println(product_name);
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,30}$";
//				if (product_name == null || product_name.trim().length() == 0) {
//					errorMsgs.put("product_name", "商品名稱：請勿空白");
//				} else if(!product_name.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.put("product_name","商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到30之間");
//	            }
				
				if(product_name.length() == 0 || product_name.trim().length() == 0) {
					String url = "/back_end/product/List_all_prods.jsp";
					req.getRequestDispatcher(url).forward(req, res);
					return;
				}
				
				
				/***************************2.開始修改資料*****************************************/
				Product_Service prodSvc = new Product_Service();
				List<ProductVO> list = null;
				list = prodSvc.getProdByLikeName(product_name.trim());
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				if(list.size() != 0) {
					req.setAttribute("prodVOs", list);
					String url = "/back_end/product/List_select_prods.jsp";
					req.getRequestDispatcher(url).forward(req, res);
				} else {
					String url = "/back_end/product/List_all_prods.jsp";
					req.getRequestDispatcher(url).forward(req, res);
				}
				
		} // if
		
		
		if("find_by_category_id".equals(action)) {
			Integer product_category_id = Integer.valueOf(req.getParameter("product_category_id"));
			
			List<ProductVO> list = null;
			Product_Service ps = new Product_Service();
			list = ps.getProductByCategoryId(product_category_id);
			
			String url = "/back_end/product/List_select_prods.jsp";
			req.setAttribute("prodVOs", list);
			req.getRequestDispatcher(url).forward(req, res);
			
		}
		
		

	} //do

}
