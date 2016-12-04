package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.appserver.dao.ProduceDAO;
import com.appserver.entity.KLClassify;
import com.appserver.entity.Produce;
import com.appserver.utils.DBHelper;

public class ProduceDAOImpl implements ProduceDAO{

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List<Produce> getAllInfo() {
		List<Produce> list = new ArrayList<Produce>();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select * from tb_produce";
			Object[] params = new Object[]{};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Produce pro = new Produce();
				pro.setProduceID(rs.getInt("produceID"));
				pro.setProduceName(rs.getString("produceName"));
				pro.setProduceDepict(rs.getString("produceDepict"));
				pro.setImgPath(rs.getString("imgPath"));
				list.add(pro);
			}
			
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
