package com.appserver.entity;

import java.util.Date;
/**
 * 
 * 项目名称：AppServer    
 * 类名称：New    
 * 类描述：新闻信息的实体类    
 * 创建人：Nicky
 * 创建时间：2016年7月18日 下午2:24:16      
 * @version
 */
public class News {
	/**
	 * 新闻ID
	 */
	private int newID;
	
	/**
	 * 新闻内容
	 */
	private String newContent;
	
	/**
	 * 新闻标题
	 */
	private String newTitle;
	
	/**
	 * 发布时间
	 */
	private Date publishTime;
	
	/**
	 * 访问量
	 */
	private int viewAmount;
	
	/**
	 * 点赞量
	 */
	private int likeAmount;
	
	/**
	 * 新闻图片路径
	 */
	private String imagePath;
	
	/**
	 * 新闻来源
	 */
	private String newsSource;

	public int getNewID() {
		return newID;
	}

	public void setNewID(int newID) {
		this.newID = newID;
	}

	public String getNewContent() {
		return newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public int getViewAmount() {
		return viewAmount;
	}

	public void setViewAmount(int viewAmount) {
		this.viewAmount = viewAmount;
	}

	public int getLikeAmount() {
		return likeAmount;
	}

	public void setLikeAmount(int likeAmount) {
		this.likeAmount = likeAmount;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

	
}
