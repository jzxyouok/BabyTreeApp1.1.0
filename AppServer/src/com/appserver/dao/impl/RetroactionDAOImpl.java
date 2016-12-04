package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.RetroactionDAO;
import com.appserver.entity.Retroaction;
import com.appserver.utils.DBHelper;

public class RetroactionDAOImpl implements RetroactionDAO{

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	/**
	 * 获取所有的信息
	 */
	@Override
	public List getAllInfo() {
		List<Vector> list = new ArrayList<Vector>();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select rID," +
						 "content," +
						 "commitTime " +
				  "from tb_retroaction,tb_members" +
				  "where tb_retroaction.memberID = tb_members.memberID";
			Object params[] = new Object[]{};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("rID"));
				v.add(rs.getString("content"));
				v.add(rs.getDate("commitTime"));
				list.add(v);
			}
			manager.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/**
	 * 保存反馈信息
	 */
	@Override
	public void saveR(Retroaction r) {
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "insert into tb_retroaction(" +
					"content," +
					"commitTime," +
					"status," +
					"memberID)" +
					"values(?,?,?,?)";
			
			Object params[] = new Object[]{
					r.getContent(),
					new Date(),
					"0",
					r.getMemberID()};
			
			manager.executeUpdate(sql, params);
			
			manager.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
