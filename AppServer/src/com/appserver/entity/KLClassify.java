package com.appserver.entity;

public class KLClassify {

	/**
	 * 育儿知识分类ID
	 */
	private int klClassifyID;
	
	/**
	 * 育儿知识分类名称
	 */
	private String klClassifyName;
	
	/**
	 * 时期ID
	 */
	private int periodID;

	public int getKlClassifyID() {
		return klClassifyID;
	}

	public void setKlClassifyID(int klClassifyID) {
		this.klClassifyID = klClassifyID;
	}

	public String getKlClassifyName() {
		return klClassifyName;
	}

	public void setKlClassifyName(String klClassifyName) {
		this.klClassifyName = klClassifyName;
	}

	public int getPeriodID() {
		return periodID;
	}

	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}
	
}
