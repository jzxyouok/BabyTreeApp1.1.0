package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.appserver.dao.MusicClassifyDAO;
import com.appserver.entity.MusicClassify;
import com.appserver.utils.DBHelper;

public class MusicClassifyDAOImpl implements MusicClassifyDAO{
	
	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List<MusicClassify> getAllInfo(){
		List<MusicClassify> list = new ArrayList<MusicClassify>();
		sql = "select * from tb_music_classify";
		try{
			Object params[] = new Object[]{};
			manager = DBHelper.createInstance();
			manager.connectDB();
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				MusicClassify mc = new MusicClassify();
				mc.setmClassifyID(rs.getInt("mClassifyID"));
				mc.setmClassifyName(rs.getString("mClassifyName"));
				mc.setmClassifyDepict(rs.getString("mClassifyDepict"));
				mc.setLogo(rs.getString("logo"));
				list.add(mc);
			}
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
