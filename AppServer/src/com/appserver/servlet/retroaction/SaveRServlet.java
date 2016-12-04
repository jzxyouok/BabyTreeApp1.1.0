package com.appserver.servlet.retroaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.appserver.dao.RetroactionDAO;
import com.appserver.dao.impl.RetroactionDAOImpl;
import com.appserver.entity.Retroaction;

public class SaveRServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		String memberID = request.getParameter("memberID");
		RetroactionDAO dao = new RetroactionDAOImpl();
		Retroaction r = new Retroaction();
		r.setContent(content);
		r.setMemberID(memberID);
		dao.saveR(r);
		JSONObject jsonObject = new JSONObject();
		try{
			jsonObject.put("ret", 0);
			jsonObject.put("msg", "ok");
			jsonObject.put("data", "");
		}catch (Exception e) {
			try {
				jsonObject.put("ret", 1);
				jsonObject.put("msg", "error");
				jsonObject.put("data", "");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		out.print(jsonObject);
		out.flush();
		out.close();
	}

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
