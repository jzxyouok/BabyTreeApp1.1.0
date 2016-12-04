package com.appserver.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.appserver.dao.GrowthLadderDAO;
import com.appserver.dao.KnowledgeDAO;
import com.appserver.dao.VideoDAO;
import com.appserver.dao.PostDAO;
import com.appserver.dao.impl.GrowthLadderDAOImpl;
import com.appserver.dao.impl.KnowledgeDAOImpl;
import com.appserver.dao.impl.VideoDAOImpl;
import com.appserver.dao.impl.PostDAOImpl;
import com.appserver.entity.Post;

public class JunitTest {
	
	public static void main(String[] args) {
		KnowledgeDAO dao = new KnowledgeDAOImpl();
		List<Vector> list = new ArrayList<Vector>();
		list = dao.getAllInfo("1");
		for(Vector v:list){
			System.out.println(v.get(2));
		}
		
		VideoDAO dao1 = new VideoDAOImpl();
		List<Vector> list1 = new ArrayList<Vector>();
		list1 = dao1.getAllInfo("1");
		for(Vector ve:list1){
			System.out.println(ve.get(2));
		}
		
//		PostDAO daoo = new PostDAOImpl();
//		Post p = new Post();
//		p.setClassifyID(1);
//		p.setCommentAmount(0);
//		p.setCommitTime(new Date());
//		p.setLikeAmount(0);
//		p.setMemberID("ara123456");
//		p.setPostContent("测试内容");
//		p.setPostTitle("测试标题");
//		daoo.sendPost(p);
		GrowthLadderDAO daoo = new GrowthLadderDAOImpl();
		List<Vector> listll=daoo.getAllInfo("ara123456");
		for(Vector v:listll){
			System.out.println(v.get(1));
		}
	}

}
