package com.appserver.dao;

import java.util.List;

import com.appserver.entity.Comment;

public interface PostCommentDAO {
	/**
	 * 获取所有的评论
	 * @param postID
	 * @return
	 */
	public List getCommentInfo(int postID);
	
	/**
	 * 评论帖子
	 */
	public void commentPost(Comment c);
}
