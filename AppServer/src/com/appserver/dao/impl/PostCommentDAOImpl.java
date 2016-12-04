package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.PostCommentDAO;
import com.appserver.entity.Comment;
import com.appserver.utils.DBHelper;

public class PostCommentDAOImpl implements PostCommentDAO{
	
	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List getCommentInfo(int postID) {
		List list = new ArrayList();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select tb_members.imgPath,tb_members.memberID,pCommentContent,pCommentTime from tb_post_comment," +
					"tb_group_post,tb_members where tb_members.memberID=tb_post_comment.memberID and tb_group_post.postID=" +
					"tb_post_comment.postID and tb_group_post.postID=?";
			Object[] params = new Object[]{postID};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("imgPath"));
				v.add(rs.getString("memberID"));
				v.add(rs.getString("pCommentContent"));
				v.add(rs.getDate("pCommentTime"));
				list.add(v);
			}
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void commentPost(Comment c) {
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "insert into tb_post_comment"
					+ "("
					+ "pCommentContent,"
					+ "pCommentTime,"
					+ "postID,"
					+ "memberID)"
					+ " values(?,?,?,?)";
			Object params[] = new Object[]{c.getpCommentContent(),
					new Date(),
					c.getPostID(),
					c.getMemberID()};
			manager.executeUpdate(sql, params);
			manager.close();
		}catch(Exception e){
			
		}
	}

}
