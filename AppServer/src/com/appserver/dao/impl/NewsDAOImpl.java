package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.NewsDAO;
import com.appserver.entity.News;
import com.appserver.utils.DBHelper;

public class NewsDAOImpl implements NewsDAO {

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	/**
	 * 获取所有的新闻信息
	 */
	@Override
	public List getAllInfo() {
		List list = new ArrayList();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select * from tb_news";
			Object[] params = new Object[]{};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("newsContent"));
				v.add(rs.getString("newsTitle"));
				v.add(rs.getDate("publishTime"));
				v.add(rs.getInt("viewAmount"));
				v.add(rs.getInt("likeAmount"));
				v.add(rs.getString("imagePath"));
				v.add(rs.getString("newsSource"));
				list.add(v);
			}
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
