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

import com.appserver.dao.PeriodDAO;
import com.appserver.dao.impl.PeriodDAOImpl;

public class GetAllPeriod extends HttpServlet {

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
		PeriodDAO dao = new PeriodDAOImpl();
		List<Vector> infoList = dao.getAllInfo();
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(Vector v:infoList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("periodID", v.get(0));
			map.put("periodName", v.get(1));
			list.add(map);
		}
		
		JSONObject jsonObject = new JSONObject();
		
		try{
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("totalNum", list.size());
			jsonObject2.put("infoList", list);
			jsonObject.put("ret", 0);
			jsonObject.put("data", jsonObject2);
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
