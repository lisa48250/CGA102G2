package com.news_post.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.news_post.model.NewsPostService;
import com.news_post.model.NewsPostVO;

@WebServlet("/xxx")
public class NewsPost_Reader2 extends HttpServlet { // 版本一
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer newsPostId = Integer.parseInt(req.getParameter("newsPostId"));
		NewsPostService newspostVOSvc = new NewsPostService(); // 設計師呼叫工地主任
		NewsPostVO newspostVO = newspostVOSvc.getOneNewsPost(newsPostId);
		byte[] newsPhotoFile = newspostVO.getNewsPhotoFile();
		String newsPhotoFileStr = Base64.getEncoder().encodeToString(newsPhotoFile);
		newspostVO.setNewsPhotoFileStr(newsPhotoFileStr);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(newspostVO);// 轉JSON格式
		res.getWriter().append(jsonStr);// 推到前端
	}
}
