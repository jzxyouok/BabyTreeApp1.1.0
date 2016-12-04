package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.GrowthLadderDAO;
import com.appserver.entity.GrowthLadder;
import com.appserver.utils.DBHelper;

public class GrowthLadderDAOImpl implements GrowthLadderDAO{
	
	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List getAllInfo(String memberID) {
		List<Vector> list = new ArrayList<Vector>();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select glID,"
					+ "label,"
					+ "tb_growth_ladder.imgPath "
					+ "from tb_growth_ladder,"
					+ "tb_members "
					+ "where tb_members.memberID = tb_growth_ladder.memberID "
					+ "and tb_growth_ladder.memberID=?";
			Object[] params = new Object[]{memberID};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("glID"));
				v.add(rs.getString("label"));
				v.add(rs.getString("imgPath"));
				list.add(v);
			}
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void saveGLI(GrowthLadder gl) {
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			
			sql = "insert into tb_growth_ladder("
					+ "label,imgPath,memberID) "
					+ "values(?,?,?)";
			Object[] params = new Object[]{
					gl.getLabel(),
					gl.getImgPath(),
					gl.getMemberID()
			};
			
			manager.executeUpdate(sql, params);
			manager.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
