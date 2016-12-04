package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.MusicDAO;
import com.appserver.utils.DBHelper;

public class MusicDAOImpl implements MusicDAO {

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List getAllInfo(String id) {
		List<Vector> list = new ArrayList<Vector>();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select musicID,"
					+ "musicPath,"
					+ "musicName,"
					+ "musicFileSize"
					+ " from tb_music,tb_music_classify"
					+ " where tb_music.mClassifyID = tb_music_classify.mClassifyID"
					+ " and tb_music.mClassifyID = ?";
			Object params[] = new Object[] {id};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("musicID"));
				v.add(rs.getString("musicPath"));
				v.add(rs.getString("musicName"));
				v.add(rs.getString("musicFileSize"));
				list.add(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
