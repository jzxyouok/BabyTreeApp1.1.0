package com.appserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.appserver.dao.KLClassifyDAO;
import com.appserver.entity.KLClassify;
import com.appserver.utils.DBHelper;

public class KLClassifyDAOImpl implements KLClassifyDAO{

	static DBHelper manager;
	String sql = "";
	static ResultSet rs;
	
	public static String[][] getInfo(){
		String s[][]=null;
		int i=0;
		int rows=0;
		String sql="select klClassifyID,klClassifyName,tb_period.periodID from tb_knowledge_classify,tb_period" +
				" where tb_knowledge_classify.periodID=tb_period.periodID order by klClassifyName desc";
		
	    try {
	    	manager = DBHelper.createInstance();
			manager.connectDB();
			Object[] params = new Object[]{};
		    rs=manager.executeQuery(sql, params);
			if(rs.last()){
				rows=rs.getRow();
			}
			if(rows==0){
	    	 s=new String[1][2];
	    	 s[0][0]="";
	    	 s[0][1]="";
	    	
			}else{
				s=new String[rows][2];
				rs.first();
				rs.previous();
				while(rs.next()){
					//s[i][2]=String.valueOf(rs.getInt("periodID"));
					s[i][0]=String.valueOf(rs.getInt("klClassifyID"));
					s[i][1]=rs.getString("klClassifyName");
					i++;
				}
			}
			manager.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    return s;
	}
	
	/**
	 * 获取所有分类信息
	 */
	@Override
	public List<KLClassify> getAllInfo() {
		List<KLClassify> list = new ArrayList<KLClassify>();
		try{
			manager = DBHelper.createInstance();
			manager.connectDB();
			sql = "select klClassifyID,klClassifyName,tb_knowledge_classify.periodID from tb_knowledge_classify,tb_period" +
					" where tb_knowledge_classify.periodID=tb_period.periodID";
			Object[] params = new Object[]{};
			rs = manager.executeQuery(sql, params);
			while(rs.next()){
				KLClassify klc = new KLClassify();
				klc.setKlClassifyID(rs.getInt("klClassifyID"));
				klc.setKlClassifyName(rs.getString("klClassifyName"));
				list.add(klc);
			
			}
			
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	class SortByID implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			KLClassify klc1 = (KLClassify)o1;
			KLClassify klc2 = (KLClassify)o2;
			if(klc1.getPeriodID()==klc2.getPeriodID())
				return 1;
			return 0;
		}
		
	}
	
	public static KLClassify[][] toShuzu(List<List<KLClassify>> list){
		KLClassify[][] array=new KLClassify[list.size()][]; 
		for(int i=0;i<list.size();i++){
			array[i] = list.get(i).toArray(new KLClassify[list.get(i).size()]);
		}
		return array;
	}
	
	public static Integer[] getID(List<KLClassify> list){
		Set<Integer> sets = new HashSet<Integer>();
		for(KLClassify klc:list){
			sets.add(klc.getPeriodID());
		}
		Integer[] set = new Integer[sets.size()];
		Iterator<Integer> ite = sets.iterator();
		int i = 0;
		while(ite.hasNext()){
			set[i] = ite.next();
			i++;
		}
		return set;
	}
	
	public static List<List<KLClassify>> getLists(Integer[] set,List<KLClassify> klcs){
		List<List<KLClassify>> list = new ArrayList<List<KLClassify>>();
		for(int j=0;j<set.length;j++){
			List<KLClassify> klcl = new ArrayList<KLClassify>();
			for(int x = 0;x<klcs.size();x++){
				KLClassify klc=klcs.get(x);
				if(klc.getPeriodID()==set[j]){
					klcl.add(klc);
				}
			}
			list.add(klcl);
		}
		return list;
	}

}
