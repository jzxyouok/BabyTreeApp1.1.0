package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.PeriodDAO;
import com.appserver.utils.DBHelper;

public class PeriodDAOImpl implements PeriodDAO {

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	/**
	 * 获取所有的孕育时期信息
	 */
	@Override
	public List getAllInfo() {
		List list = new ArrayList();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select * from tb_period";
			Object[] params = new Object[]{};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("periodID"));
				v.add(rs.getString("periodName"));
				list.add(v);
			}
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
