package com.appserver.entity;

public class GrowthLadder {
	
	/**
	 * 成长阶梯ID
	 */
	private int glID;
	
	/**
	 * 标记
	 */
	private String label;
	
	/**
	 * 图片路径
	 */
	private String imgPath;
	
	/**
	 * 会员ID
	 */
	private String memberID;
	
	public int getGlID() {
		return glID;
	}

	public void setGlID(int glID) {
		this.glID = glID;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

}
