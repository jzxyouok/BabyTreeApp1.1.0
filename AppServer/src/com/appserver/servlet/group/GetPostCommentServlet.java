package com.appserver.servlet.group;

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

import com.appserver.dao.ClassifyDAO;
import com.appserver.dao.PostCommentDAO;
import com.appserver.dao.impl.ClassifyDAOImpl;
import com.appserver.dao.impl.PostCommentDAOImpl;
import com.appserver.utils.TextUtility;

public class GetPostCommentServlet extends HttpServlet {

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
		String postIDStr = request.getParameter("postID");
		int postID = TextUtility.String2Int(postIDStr);
		PostCommentDAO dao = new PostCommentDAOImpl();
		List<Vector> infoList = dao.getCommentInfo(postID);
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		for(Vector v:infoList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("imgPath", v.get(0));
			map.put("memberID", v.get(1));
			map.put("pCommentContent", v.get(2));
			map.put("pCommentTime", v.get(3));
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
