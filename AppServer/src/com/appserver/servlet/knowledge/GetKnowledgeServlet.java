package com.appserver.servlet.knowledge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.appserver.dao.KnowledgeDAO;
import com.appserver.dao.impl.KnowledgeDAOImpl;

public class GetKnowledgeServlet extends HttpServlet {

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
		String id = request.getParameter("id");
		KnowledgeDAO dao = new KnowledgeDAOImpl();
		List<Vector> kList = dao.getAllInfo(id);
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(Vector v:kList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("klID", v.get(0));
			map.put("klTitle", v.get(1));
			map.put("klContent", v.get(2));
			map.put("klImage", v.get(3));
			map.put("likeAmount", v.get(4));
			map.put("unlikeAmount", v.get(5));
			list.add(map);
		}
		
		JSONObject jsonObj = new JSONObject();
		
		try{
			JSONObject jsonObj2 = new JSONObject();
			jsonObj2.put("totalNum", list.size());
			jsonObj2.put("infoList", list);
			jsonObj.put("ret", 0);
			jsonObj.put("data", jsonObj2);
		}catch (Exception e) {}
		out.print(jsonObj);
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
