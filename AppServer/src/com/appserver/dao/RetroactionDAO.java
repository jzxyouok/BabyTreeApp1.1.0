package com.appserver.dao;

import java.util.List;

import com.appserver.entity.Retroaction;

public interface RetroactionDAO {
	
	public List getAllInfo();
	
	public void saveR(Retroaction r);

}
