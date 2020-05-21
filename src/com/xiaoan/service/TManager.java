package com.xiaoan.service;

import com.xiaoan.model.ManagerTable;

public interface TManager {
	//µÇÂ¼
	public ManagerTable queryMangerTable(String username,String userpwd) throws Exception;
	//×¢²á
	public int AddManager(ManagerTable tm) throws Exception;
}
