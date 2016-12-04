package com.appserver.dao;

import java.util.List;

import com.appserver.entity.Post;

public interface PostDAO {

	/**
	 * 获取所有的帖子信息
	 * @return
	 */
	public List getPostByGroupId(int id);
	
	public boolean sendPost(Post p);
}
