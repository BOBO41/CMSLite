package com.xiang.server;

public interface BaseServer {
	public void setDelById(String table,Long[] ids, Boolean del);
	public void setFlag(String table,String field,Long[] ids, Object flag);
	public Long getMax(String table,String field);
}
