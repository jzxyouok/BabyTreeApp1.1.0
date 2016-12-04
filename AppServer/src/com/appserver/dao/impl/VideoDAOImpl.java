package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.VideoDAO;
import com.appserver.utils.DBHelper;

public class VideoDAOImpl implements VideoDAO {

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getAllInfo(String id) {
		List<Vector> list = new ArrayList<Vector>();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select videoID,"
					+ "videoName,"
					+ "videoPath,"
					+ "videoDepict,"
					+ "videoFileSize"
					+ " from tb_video,tb_video_classify"
					+ " where tb_video.mClassifyID = tb_video_classify.mClassifyID"
					+ " and tb_video.mClassifyID=?";
			Object params[] = new Object[] {id};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("videoID"));
				v.add(rs.getString("videoName"));
				v.add(rs.getString("videoPath"));
				v.add(rs.getString("videoDepict"));
				v.add(rs.getString("videoFileSize"));
				list.add(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
