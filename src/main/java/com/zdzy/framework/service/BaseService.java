package com.zdzy.framework.service;

import java.io.Serializable;
import java.util.List;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;


public interface BaseService <T, PK extends Serializable>{
	
	    public PK save(T model);

	    public void saveOrUpdate(T model);
	    
	    public void update(T model);
	    
	    public void merge(T model);

	    public void delete(PK id);

	    public void deleteObject(T model);

	    public T get(PK id);
	    
	    public int count();
	    
	    public List<T> listAll();
		public PageObject query(QueryParamater param);

}
