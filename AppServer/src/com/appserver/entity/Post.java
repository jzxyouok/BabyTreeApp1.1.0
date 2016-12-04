package com.appserver.entity;

import java.util.Date;

public class Post {

	/**
	 * 帖子Id
	 */
	private int postID;
	
	/**
	 * 帖子标题
	 */
	private String postTitle;
	
	/**
	 * 帖子内容
	 */
	private String postContent;
	
	/**
	 * 点赞量
	 */
	private int likeAmount;
	
	/**
	 * 评论量
	 */
	private int commentAmount;
	
	/**
	 * 提交时间
	 */
	private Date commitTime;
	
	/**
	 * 圈子ID
	 */
	private int classifyID;
	
	/**
	 * 会员ID
	 */
	private String memberID;

	public Date getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

	public int getClassifyID() {
		return classifyID;
	}

	public void setClassifyID(int classifyID) {
		this.classifyID = classifyID;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public int getLikeAmount() {
		return likeAmount;
	}

	public void setLikeAmount(int likeAmount) {
		this.likeAmount = likeAmount;
	}

	public int getCommentAmount() {
		return commentAmount;
	}

	public void setCommentAmount(int commentAmount) {
		this.commentAmount = commentAmount;
	}
	
}
