package com.appserver.servlet.growthladder;

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

import com.appserver.dao.GrowthLadderDAO;
import com.appserver.dao.impl.GrowthLadderDAOImpl;

public class GetGLInfoServlet extends HttpServlet {

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
		String memberID = request.getParameter("memberID");
		GrowthLadderDAO dao = new GrowthLadderDAOImpl();
		List<Vector> infoList = dao.getAllInfo(memberID);
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		for(Vector v:infoList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("glID", v.get(0));
			map.put("label", v.get(1));
			map.put("imgPath", v.get(2));
			list.add(map);
		}
		
		JSONObject jsonObject = new JSONObject();
		
		try{
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("totalNum", list.size());
			jsonObject2.put("infoList", list);
			
			jsonObject.put("data", jsonObject2);
			jsonObject.put("ret", 0);
			
		}catch(Exception e){
			e.printStackTrace();
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
