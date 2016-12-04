package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.appserver.dao.VideoClassifyDAO;
import com.appserver.entity.VideoClassify;
import com.appserver.utils.DBHelper;

public class VideoClassifyDAOImpl implements VideoClassifyDAO{
	
	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List<VideoClassify> getAllInfo(){
		List<VideoClassify> list = new ArrayList<VideoClassify>();
		sql = "select * from tb_video_classify";
		try{
			Object params[] = new Object[]{};
			manager = DBHelper.createInstance();
			manager.connectDB();
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				VideoClassify mc = new VideoClassify();
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
