package com.appserver.dao;

import java.util.List;

import com.appserver.entity.GrowthLadder;

public interface GrowthLadderDAO {
	
	public List getAllInfo(String memberID);
	
	public void saveGLI(GrowthLadder gl);

}
