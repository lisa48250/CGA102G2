package h.com.new_list.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h.com.new_list.model.News_listService;

@WebServlet("/NewsReader")
public class News_list_Reader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		News_listService list = new News_listService();
		String id = null;
		try {
			
			 id = req.getParameter("news_id").trim();
			int num = Integer.parseInt(id);
			InputStream in = new ByteArrayInputStream(list.findByPrimaryKeyNews(num).getNews_id_photo());
			BufferedInputStream bin = new BufferedInputStream(in);
			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = bin.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
