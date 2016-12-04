package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.ClassifyDAO;
import com.appserver.utils.DBHelper;

public class ClassifyDAOImpl implements ClassifyDAO{

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	/**
	 * 获取所有的圈子信息
	 */
	@Override
	public List getAllInfo() {
		List list = new ArrayList();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select * from tb_group_classify";
			Object[] params = new Object[]{};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("classifyID"));
				v.add(rs.getString("classifyName"));
				v.add(rs.getInt("attentionAmount"));
				v.add(rs.getInt("topicAmount"));
				v.add(rs.getString("logo"));
				list.add(v);
			}
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
