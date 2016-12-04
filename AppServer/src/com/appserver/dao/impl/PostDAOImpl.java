package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.PostDAO;
import com.appserver.entity.Post;
import com.appserver.utils.DBHelper;

public class PostDAOImpl implements PostDAO {
	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List getPostByGroupId(int id) {
		List list = new ArrayList();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select postID,postTitle,postContent,likeAmount,commentAmount,commitTime," +
					"tb_members.imgPath,tb_members.memberID from tb_group_post,tb_members " +
					"where tb_group_post.memberID=tb_members.memberID and classifyID=?";
			Object[] params = new Object[]{id};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("postID"));
				v.add(rs.getString("postTitle"));
				v.add(rs.getString("postContent"));
				v.add(rs.getInt("likeAmount"));
				v.add(rs.getInt("commentAmount"));
				v.add(rs.getDate("commitTime"));
				v.add(rs.getString("imgPath"));
				v.add(rs.getString("memberID"));
				list.add(v);
			}
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean sendPost(Post p) {
		boolean flag = false;
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "insert into tb_group_post"
					+ "(postTitle,"
					+ "postContent,"
					+ "likeAmount,"
					+ "commentAmount,"
					+ "commitTime,"
					+ "classifyID,"
					+ "memberID) values(?,?,?,?,?,?,?)";
			Object[] params = new Object[]{
					p.getPostTitle(),
					p.getPostContent(),
					0,
					0,
					new Date(),
					p.getClassifyID(),
					p.getMemberID()
			};
			manager.executeUpdate(sql, params);
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
		return flag;
	}

}
