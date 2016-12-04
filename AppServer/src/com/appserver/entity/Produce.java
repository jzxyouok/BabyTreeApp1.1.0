package com.appserver.entity;

public class Produce {
	
	/**
	 * 产品ID
	 */
	private int produceID;

	/**
	 * 产品名称
	 */
	private String produceName;
	
	/**
	 * 产品介绍
	 */
	private String produceDepict;
	
	/**
	 * 产品图片
	 */
	private String imgPath;

	public int getProduceID() {
		return produceID;
	}

	public void setProduceID(int produceID) {
		this.produceID = produceID;
	}

	public String getProduceName() {
		return produceName;
	}

	public void setProduceName(String produceName) {
		this.produceName = produceName;
	}

	public String getProduceDepict() {
		return produceDepict;
	}

	public void setProduceDepict(String produceDepict) {
		this.produceDepict = produceDepict;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
