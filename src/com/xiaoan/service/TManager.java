package com.xiaoan.service;

import com.xiaoan.model.ManagerTable;

public interface TManager {
	//��¼
	public ManagerTable queryMangerTable(String username,String userpwd) throws Exception;
	//ע��
	public int AddManager(ManagerTable tm) throws Exception;
}
