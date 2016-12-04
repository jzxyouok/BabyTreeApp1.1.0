package com.appserver.servlet.music;

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

import com.appserver.dao.MusicDAO;
import com.appserver.dao.impl.MusicDAOImpl;

public class GetMusicServlet extends HttpServlet {

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
		String id = request.getParameter("classifyID");
		MusicDAO dao = new MusicDAOImpl();
		List<Vector> musicList = dao.getAllInfo(id);
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(Vector v:musicList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("musicID", v.get(0));
			map.put("musicPath", v.get(1));
			map.put("musicName", v.get(2));
			map.put("musicFileSize", v.get(3));
			list.add(map);
		}
		JSONObject jsonObj = new JSONObject();
		
		JSONObject jsonObj2 = new JSONObject();
		try{
			jsonObj2.put("totalNum", list.size());
			jsonObj2.put("infoList", list);
			
			jsonObj.put("data", jsonObj2);
			jsonObj.put("ret", 0);
		}catch(Exception e){
			e.printStackTrace();
		}
		out.println(jsonObj);
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
