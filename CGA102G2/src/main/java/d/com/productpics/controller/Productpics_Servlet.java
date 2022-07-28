package d.com.productpics.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import d.com.product.model.Product_Service;
import d.com.productpics.model.Product_pics_Service;
import d.com.productpics.model.Product_pics_VO;

@WebServlet("/prodpics_ServletD")

@MultipartConfig(fileSizeThreshold=1024*1024, maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
public class Productpics_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("product_photo_id");
//System.out.println(str);
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("product_photo_id", "請輸入商品圖片編號");
			}
				Integer product_photo_id = Integer.valueOf(str);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				// 要再調整
				RequestDispatcher failureView = req.getRequestDispatcher("back_end/product_pics/Select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
// 要再確認，如同時傳		
//			str = req.getParameter("product_id");
//
//			Integer product_photo_id = null;
//			try {
//				product_photo_id = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.put("product_id", "商品編號格式不正確");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				// 要再調整
//				RequestDispatcher failureView = req.getRequestDispatcher("back_end/product_pics/Select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

			/*************************** 2.開始查詢資料 *****************************************/
			Product_pics_Service prodSvc = new Product_pics_Service();
			Product_pics_VO productpicsVO = prodSvc.getOnePicByPrimarykey(product_photo_id);
			if (productpicsVO == null) {
				errorMsgs.put("product_photo_id", "查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				// 要再調整
				RequestDispatcher failureView = req.getRequestDispatcher("back_end/product_pics/Select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("prodVO", productpicsVO); // 資料庫取出的productVO物件,存入req
// 要再調整				
			String url = "back_end/product_pics/List_one_prodpic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		} // if

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer product_photo_id = Integer.valueOf(req.getParameter("product_photo_id"));

			/*************************** 2.開始查詢資料 ****************************************/
			Product_pics_Service prodpicSvc = new Product_pics_Service();
			Product_pics_VO product_picsVO = prodpicSvc.getOnePicByPrimarykey(product_photo_id);
System.out.println(product_picsVO.getProduct_photo_id());
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
//			String param = "?product_photo_id=" + productVO.getProduct_photo_id() + "&product_id="
//					+ productVO.getProduct_id();// + "&product_photo=" + productVO.getProduct_photo();
//			String url = "/productpics/update_productpics.jsp" + param;
			String url = "back_end/product_pics/Update_prodpics.jsp";
			req.setAttribute("product_picsVO", product_picsVO); // 資料庫取出的empVO物件,存入req
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllProds.jsp

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer product_id = Integer.valueOf(req.getParameter("product_photo_id"));

			/*************************** 2.開始刪除資料 ***************************************/
			Product_Service prodSvc = new Product_Service();
			prodSvc.deleteProduct(product_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "back_end/product_pics/List_all_prodpics.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

//      ----------------------------------------------		
		if ("update".equals(action)) { // 來自update_productpics.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//				ProductVO prodVO = new ProductVO();
			Integer product_photo_id = Integer.valueOf(req.getParameter("product_photo_id").trim());
			Integer product_id = Integer.valueOf(req.getParameter("product_id").trim());
//System.out.println(product_photo_id);
//System.out.println("    " + product_id);
//				Integer product_quantity = null;
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

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("back_end/product_pics/Update_prodpics.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

//			Part part = req.getPart("product_photo");
//			InputStream in = part.getInputStream();
//			byte[] pic = new byte[in.available()];
//			in.read(pic);
//			in.close();

			
			InputStream in = req.getPart("product_photo").getInputStream();
			byte[] product_photo = new byte[in.available()];
			in.read(product_photo);
			in.close();

			Product_pics_Service prodSvc = new Product_pics_Service();
			Product_pics_VO prodVO = new Product_pics_VO();
			
			prodVO = prodSvc.updateProductPics(product_photo_id, product_id, product_photo);
//System.out.println(prodVO.getProduct_photo_id());
//				<input type="file" name="xxx">
//				InputStream is = req.getPart("room_type_pic").getInputStream();
//				BufferedInputStream bis = new BufferedInputStream(is);
//				byte[] bytes = new byte[bis.available()];
//				bis.read(bytes);
//				Blob product_photo = null;
//				try {
//					product_photo = new SerialBlob(bytes);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

//				ProductpicsService prodSvc = new ProductpicsService();
//				Product_picsVO prodVO = new Product_picsVO();
//				prodVO = prodSvc.updateProductPics(product_photo_id, product_id, product_photo);
//				

//				if (!errorMsgs.isEmpty()) {
//					// 要再調整
//					//req.setAttribute("product_picsVO", product_picsVO);
//					RequestDispatcher failureView = req.getRequestDispatcher("/productpics/select_page.jsp");
//					failureView.forward(req, res);
//					return;// 程式中斷
//				}
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("prodVO", prodVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "back_end/product_pics/List_one_prodpic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

//		----------------------------------------------
		if ("insert".equals(action)) { // 來自update_product.jsp的請求
//System.out.println(2222222);
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

//			Integer product_photo_id = Integer.valueOf(req.getParameter("product_photo_id").trim());
			Integer product_id = Integer.valueOf(req.getParameter("product_id").trim());

//System.out.println(product_id);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("back_end/product_pics/Add_prodpics.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
//			Part part = req.getPart("product_photo");
			InputStream in = req.getPart("product_photo").getInputStream();
			byte[] product_photo = new byte[in.available()];
		    in.read(product_photo);
			in.close();
//System.out.println(product_photo);
			

			Product_pics_Service prodSvc = new Product_pics_Service();
			Product_pics_VO prodVO = new Product_pics_VO();
			prodVO = prodSvc.addOneProductPics(product_id, product_photo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("prodVO", prodVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "back_end/product_pics/List_one_prodpic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

//		--------------------------

	} // servlet

}
