package com.appserver.entity;

public class MusicClassify {
	
	/**
	 * 早教音乐分类ID
	 */
	private int mClassifyID;
	
	/**
	 * 音乐分类名称
	 */
	private String mClassifyName;
	
	/**
	 * 音乐类别描述
	 */
	private String mClassifyDepict;
	
	/**
	 * 音乐类别LOGO
	 */
	private String logo;

	public int getmClassifyID() {
		return mClassifyID;
	}

	public void setmClassifyID(int mClassifyID) {
		this.mClassifyID = mClassifyID;
	}

	public String getmClassifyName() {
		return mClassifyName;
	}

	public void setmClassifyName(String mClassifyName) {
		this.mClassifyName = mClassifyName;
	}

	public String getmClassifyDepict() {
		return mClassifyDepict;
	}

	public void setmClassifyDepict(String mClassifyDepict) {
		this.mClassifyDepict = mClassifyDepict;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
