package com.appserver.servlet.news;

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

import com.appserver.dao.NewsDAO;
import com.appserver.dao.impl.NewsDAOImpl;
/**
 * 
 * 项目名称：AppServer    
 * 类名称：GetAllNewsServlet    
 * 类描述：获取所有新闻的控制类    
 * 创建人：Nicky
 * 创建时间：2016年7月18日 下午3:01:08      
 * @version
 */
public class GetAllNewsServlet extends HttpServlet {

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
		NewsDAO dao = new NewsDAOImpl();
		List<Vector> newsList = dao.getAllInfo();
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(Vector v:newsList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("newsContent", v.get(0));
			map.put("newsTitle", v.get(1));
			map.put("publishTime", v.get(2));
			map.put("viewAmount", v.get(3));
			map.put("likeAmount", v.get(4));
			map.put("imagePath", v.get(5));
			map.put("newsSource", v.get(6));
			list.add(map);
		}
		
		JSONObject jsonObject = new JSONObject();
		
		try{
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("totalNum", list.size());
			jsonObject2.put("newsList", list);
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
