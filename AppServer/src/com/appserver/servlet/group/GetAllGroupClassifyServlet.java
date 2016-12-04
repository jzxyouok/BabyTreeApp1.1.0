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
import com.appserver.dao.impl.ClassifyDAOImpl;
/**
 * 项目名称：AppServer    
 * 类名称：GetAllGroupClassifyServlet    
 * 类描述：获取所有的圈子分类信息    
 * 创建人：Nicky
 * 创建时间：2016年7月19日 下午1:59:23      
 * @version
 */
public class GetAllGroupClassifyServlet extends HttpServlet {

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
		ClassifyDAO dao = new ClassifyDAOImpl();
		List<Vector> infoList = dao.getAllInfo();
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		for(Vector v:infoList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("classifyID", v.get(0));
			map.put("classifyName", v.get(1));
			map.put("attentionAmount", v.get(2));
			map.put("topicAmount", v.get(3));
			map.put("logo", v.get(4));
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
