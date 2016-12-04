package com.appserver.entity;
/**
 * 项目名称：AppServer    
 * 类名称：Period    
 * 类描述：孕育时期信息的实体类    
 * 创建人：Nicky
 * 创建时间：2016年8月11日 下午3:49:02      
 * @version
 */
public class Period {

	/**
	 * 孕育时期ID
	 */
	private int periodID;
	
	/**
	 * 孕育时期名称
	 */
	private String periodName;

	public int getPeriodID() {
		return periodID;
	}

	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

}
