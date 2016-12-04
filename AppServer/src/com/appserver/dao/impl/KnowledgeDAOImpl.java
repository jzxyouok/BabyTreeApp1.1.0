package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.KnowledgeDAO;
import com.appserver.utils.DBHelper;

public class KnowledgeDAOImpl implements KnowledgeDAO{

	DBHelper manager;
	String sql = "";
	ResultSet rs;
	
	@Override
	public List getAllInfo(String id){
		List<Vector> list = new ArrayList<Vector>();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select klID,klTitle,klContent,klImage,likeAmount," +
					"unlikeAmount from tb_knowledge,tb_knowledge_classify" +
					" where tb_knowledge.klClassifyID = tb_knowledge_classify.klClassifyID" +
					" and tb_knowledge.klClassifyID=?";
			Object params[] = new Object[]{id};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("klID"));
				v.add(rs.getString("klTitle"));
				v.add(rs.getString("klContent"));
				v.add(rs.getString("klImage"));
				v.add(rs.getInt("likeAmount"));
				v.add(rs.getInt("unlikeAmount"));
				list.add(v);
			}
			manager.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	
}
