package com.appserver.entity;

import java.util.Date;

public class Retroaction {
	
	/**
	 * 反馈ID
	 */
	private int rID;
	
	/**
	 * 反馈内容
	 */
	private String content;
	
	/**
	 * 提交时间
	 */
	private Date commitTime;
	
	/**
	 * 消息处理状态
	 */
	private String status;
	
	/**
	 * 会员ID，外键
	 */
	private String memberID;

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
}
