package com.appserver.dao;

import com.appserver.entity.Member;


public interface MemberDAO {
	
	/**
	 * 登录验证
	 */
	public boolean loginCheck(String account,String password);
	
	/**
	 * 会员注册
	 */
	public void register(Member member);
	
}
