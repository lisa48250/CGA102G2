package h.com.room_type_photo.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h.com.room_type_photo.model.Room_type_photoService;

@WebServlet("/RoomPhotoReader")
public class RoomPhotoReader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoomPhotoReader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		Room_type_photoService rtps = new Room_type_photoService();
		String id = null;
		Integer num = null;
		InputStream in;
		try {	
			id = req.getParameter("room_type_photo_id").trim();
			num = Integer.valueOf(id);
			
			in = rtps.getOneRoom_Type_Photo(num).getRoom_type_photo().getBinaryStream();
			BufferedInputStream bin = new BufferedInputStream(in);
			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = bin.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
