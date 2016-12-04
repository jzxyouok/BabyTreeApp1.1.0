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

import com.appserver.dao.MusicClassifyDAO;
import com.appserver.dao.impl.MusicClassifyDAOImpl;
import com.appserver.entity.MusicClassify;

public class GetMusicClassifyServlet extends HttpServlet {

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
		MusicClassifyDAO dao = new MusicClassifyDAOImpl();
		List<MusicClassify> infoList = dao.getAllInfo();
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		for(MusicClassify mc:infoList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("mClassifyID", mc.getmClassifyID());
			map.put("mClassifyName", mc.getmClassifyName());
			map.put("mClassifyDepict", mc.getmClassifyDepict());
			map.put("logo", mc.getLogo());
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
