package p.com.productcategory.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.com.productcategory.model.Product_category_Service;
import p.com.productcategory.model.Product_category_VO;


@WebServlet("/product_category.do")
public class Product_category_ServletD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Product_category_Service ProdSvc = new Product_category_Service();


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
	
		if ("getOne_For_Display".equals(action)) { // come from select_page.jsp

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("product_category_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.put("product_category_id", "請輸入商品編號");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product_category/Select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				Integer product_category_id = null;
				try {
					product_category_id = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.put("product_category_id","商品編號需為數字");
				}
				 
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product_category/Select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始查詢資料*****************************************/
				Product_category_Service prodSvc = new Product_category_Service();
				Product_category_VO productcategoryVO = prodSvc.getOneProductByPrimarykey(product_category_id);
				if (productcategoryVO == null) {
					errorMsgs.put("product_category_id", "查無資料");
				}
				 
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product_category/Select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prodVO", productcategoryVO);
				
				String url = "/back_end/product_category/List_one_prodcat.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
//		----------------------------------------------
		if ("getOne_For_Update".equals(action)) {

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer product_category_id = Integer.valueOf(req.getParameter("product_category_id"));

				/***************************2.開始更新資料****************************************/
				Product_category_Service prodSvc = new Product_category_Service();
				Product_category_VO productcategoryVO = prodSvc.getOneProductByPrimarykey(product_category_id);
	
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?product_category_id="  +productcategoryVO.getProduct_category_id()+
						       "&product_category_name="  +productcategoryVO.getProduct_category_name()+						       
						       "&product_category_detail="+productcategoryVO.getProduct_category_detail();
				String url = "/back_end/product_category/Update_product_category.jsp"+param;
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}		
		
		
//		----------------------------------------------
		if ("delete".equals(action)) {

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			/***************************1.接收請求參數***************************************/
				Integer product_category_id = Integer.valueOf(req.getParameter("product_category_id"));
				
				/***************************2.開始刪除資料***************************************/
				Product_category_Service prodSvc = new Product_category_Service();
				prodSvc.deleteProduct(product_category_id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back_end/product_category/List_all_prodcats.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}		
		
//		----------------------------------------------
		if ("update".equals(action)) {
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer product_category_id = Integer.valueOf(req.getParameter("product_category_id").trim());
				
				String product_category_name = req.getParameter("product_category_name");
				
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,30}$";
				if (product_category_name == null || product_category_name.trim().length() == 0) {
					errorMsgs.put("product_category_name", "商品名稱請勿空白");
				} else if(!product_category_name.trim().matches(enameReg)) {//(regular-expression)
					errorMsgs.put("product_category_name","商品名稱只能是中、英文字母、數字和_ , 且長度必需在2到30之間");
	            }
				
				String product_category_detail = req.getParameter("product_category_detail");
				enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,1000}$";
				if (product_category_detail == null || product_category_detail.trim().length() == 0) {
					errorMsgs.put("product_category_detail", "商品說明請勿空白");
				} else if(!product_category_name.trim().matches(enameReg)) {//(regular-expression)
					errorMsgs.put("product_category_detail","商品說明只能是中、英文字母、數字和_ , 且長度必需在2到1000之間");
	            }

				 
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product_category/Update_product_category.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始修改資料*****************************************/
				Product_category_Service prodSvc = new Product_category_Service();
				Product_category_VO prodVO = new Product_category_VO();
				prodVO = prodSvc.updateProduct_categoryVO(product_category_id, product_category_name, product_category_detail);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prodVO", prodVO);
//				String url = "/back_end/product_category/List_one_prodcat.jsp";
				String url = "/back_end/product_category/List_all_prodcats.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
//		----------------------------------------------
		if ("insert".equals(action)) {
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				// Integer product_category_id = Integer.valueOf(req.getParameter("product_category_id").trim());
				
				String product_category_name = req.getParameter("product_category_name");
				
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,30}$";
				if (product_category_name == null || product_category_name.trim().length() == 0) {
					errorMsgs.put("product_category_name","商品類別名稱請勿空白");
				} else if(!product_category_name.trim().matches(enameReg)) { //(regular-expression)
					errorMsgs.put("product_category_name","商品類別名稱只能是中、英文字母、數字和_ , 且長度必需在2到30之間");
	            }
				
				String product_category_detail = req.getParameter("product_category_detail");
				enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,1000}$";
				if (product_category_detail == null || product_category_detail.trim().length() == 0) {
					errorMsgs.put("product_category_detail", "商品類別說明請勿空白");
				} else if(!product_category_name.trim().matches(enameReg)) { //(regular-expression)
					errorMsgs.put("product_category_detail","商品類別說明只能是中、英文字母、數字和_ , 且長度必需在2到1000之間");
	            }

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/product_category/Add_product_category.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始修改資料*****************************************/
				Product_category_Service prodSvc = new Product_category_Service();
				Product_category_VO prodVO = new Product_category_VO();
				prodVO = prodSvc.addOneProductCategory(/*product_category_id,*/ product_category_name, product_category_detail);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prodVO", prodVO);
				
//				String url = /*req.getContextPath()+*/"/back_end/product_category/List_one_prodcat.jsp";
				String url = /*req.getContextPath()+*/"/back_end/product_category/List_all_prodcats.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
//		--------------------------
	}

}
