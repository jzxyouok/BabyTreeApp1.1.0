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

import com.appserver.dao.NewsDAO;
import com.appserver.dao.PostDAO;
import com.appserver.dao.impl.NewsDAOImpl;
import com.appserver.dao.impl.PostDAOImpl;
import com.appserver.utils.TextUtility;

/**
 * 项目名称：AppServer    
 * 类名称：GetGroupPostByIdServlet    
 * 类描述：获取圈子里的帖子信息    
 * 创建人：Nicky
 * 创建时间：2016年8月4日 下午9:20:05      
 * @version
 */
public class GetGroupPostByIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String idString = request.getParameter("groupId");
		int id = TextUtility.String2Int(idString);
		PrintWriter out = response.getWriter();
		PostDAO dao = new PostDAOImpl();
		List<Vector> postList = dao.getPostByGroupId(id);
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(Vector v:postList){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("postID", v.get(0));
			map.put("postTitle", v.get(1));
			map.put("postContent", v.get(2));
			map.put("likeAmount", v.get(3));
			map.put("commentAmount", v.get(4));
			map.put("commitTime", v.get(5));
			map.put("imgPath", v.get(6));
			map.put("memberID", v.get(7));
			list.add(map);
		}
		
		JSONObject jsonObject = new JSONObject();
		
		try{
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("totalNum", list.size());
			jsonObject2.put("postList", list);
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
