package com.appserver.servlet.group;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.appserver.dao.PostCommentDAO;
import com.appserver.dao.PostDAO;
import com.appserver.dao.impl.PostCommentDAOImpl;
import com.appserver.dao.impl.PostDAOImpl;
import com.appserver.entity.Comment;
import com.appserver.entity.Post;
import com.appserver.utils.TextUtility;

public class SendPostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		String memberID = request.getParameter("memberID");
		String classifyID = request.getParameter("classifyID");
		Post p = new Post();
		p.setPostTitle(postTitle);
		p.setPostContent(postContent);
		p.setClassifyID(TextUtility.String2Int(classifyID));
		p.setMemberID(memberID);
		PostDAO dao = new PostDAOImpl();
		dao.sendPost(p);
		JSONObject jObject = new JSONObject();
		try{
			jObject.put("ret", 0);
			jObject.put("msg", "ok");
			jObject.put("data", "");
		}catch(Exception e){
			e.printStackTrace();
			try
			{
				jObject.put("ret", 1);
				jObject.put("msg", "error");
				jObject.put("data", "");
			} catch (JSONException ex)
			{
				ex.printStackTrace();
			}
		}
		
		out.flush();
		out.close();
		
	}

}
