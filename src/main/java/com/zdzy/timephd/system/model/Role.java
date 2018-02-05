package com.zdzy.timephd.system.model;

import java.util.Date;

import com.zdzy.framework.bean.BaseBean;

public class Role extends BaseBean{

	private String id; //
	private String name; //
	private int mark; //
	private Date createdate; //
	private Date updatedate; //
	private String description; //
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setMark(int mark){
		this.mark=mark;
	}
	
	public void setCreatedate(Date createdate){
		this.createdate=createdate;
	}
	
	public void setUpdatedate(Date updatedate){
		this.updatedate=updatedate;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	 
	public String getId(){
		return id;
	}
	 
	public String getName(){
		return name;
	}
	 
	public int getMark(){
		return mark;
	}
	 
	public Date getCreatedate(){
		return createdate;
	}
	 
	public Date getUpdatedate(){
		return updatedate;
	}
	 
	public String getDescription(){
		return description;
	}
}