package com.appserver.entity;
/**
 * 
 * @author Nicky
 * 育儿知识信息的实体类
 *
 */
public class Knowledge {
	
	/**
	 * 知识ID
	 */
	private int klID;
	
	/**
	 * 知识标题
	 */
	private String klTitle;
	
	/**
	 * 知识内容
	 */
	private String klContent;
	
	/**
	 * 图片
	 */
	private String klImage;
	
	/**
	 * 点赞量
	 */
	private int likeAmount;
	
	/**
	 * 吐槽量
	 */
	private int unlikeAmount;
	
	/**
	 * 知识分类ID
	 */
	private int klClassifyID;

	public int getKlID() {
		return klID;
	}

	public void setKlID(int klID) {
		this.klID = klID;
	}

	public String getKlTitle() {
		return klTitle;
	}

	public void setKlTitle(String klTitle) {
		this.klTitle = klTitle;
	}

	public String getKlContent() {
		return klContent;
	}

	public void setKlContent(String klContent) {
		this.klContent = klContent;
	}

	public String getKlImage() {
		return klImage;
	}

	public void setKlImage(String klImage) {
		this.klImage = klImage;
	}

	public int getLikeAmount() {
		return likeAmount;
	}

	public void setLikeAmount(int likeAmount) {
		this.likeAmount = likeAmount;
	}

	public int getUnlikeAmount() {
		return unlikeAmount;
	}

	public void setUnlikeAmount(int unlikeAmount) {
		this.unlikeAmount = unlikeAmount;
	}

	public int getKlClassifyID() {
		return klClassifyID;
	}

	public void setKlClassifyID(int klClassifyID) {
		this.klClassifyID = klClassifyID;
	}
	
}
