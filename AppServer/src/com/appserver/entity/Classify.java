package com.appserver.entity;
/**
 * 项目名称：AppServer    
 * 类名称：Classify    
 * 类描述：圈子分类信息的实体类    
 * 创建人：Nicky
 * 创建时间：2016年7月19日 下午2:15:43      
 * @version
 */
public class Classify {

	/**
	 * 圈子ID
	 */
	private int classifyID;
	
	/**
	 * 圈子名称
	 */
	private String classifyName;
	
	/**
	 * 圈子公众量
	 */
	private int attentionAmount;
	
	/**
	 * 圈子今日话题量
	 */
	private int topicAmount;
	
	/**
	 * 圈子logo
	 */
	private String logo;

	public int getClassifyID() {
		return classifyID;
	}

	public void setClassifyID(int classifyID) {
		this.classifyID = classifyID;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public int getAttentionAmount() {
		return attentionAmount;
	}

	public void setAttentionAmount(int attentionAmount) {
		this.attentionAmount = attentionAmount;
	}

	public int getTopicAmount() {
		return topicAmount;
	}

	public void setTopicAmount(int topicAmount) {
		this.topicAmount = topicAmount;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
