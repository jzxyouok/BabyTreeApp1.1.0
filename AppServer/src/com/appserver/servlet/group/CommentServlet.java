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
import com.appserver.dao.impl.PostCommentDAOImpl;
import com.appserver.entity.Comment;
import com.appserver.entity.Member;
import com.appserver.utils.TextUtility;

public class CommentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String pCommentContent = new String(request.getParameter("pCommentContent").getBytes("iso-8859-1"),"UTF-8");
		String postID = request.getParameter("postID");
		String memberID = request.getParameter("memberID");
		Comment c = new Comment();
		c.setpCommentContent(pCommentContent);
		c.setPostID(TextUtility.String2Int(postID));
		c.setMemberID(memberID);
		PostCommentDAO dao = new PostCommentDAOImpl();
		dao.commentPost(c);
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
