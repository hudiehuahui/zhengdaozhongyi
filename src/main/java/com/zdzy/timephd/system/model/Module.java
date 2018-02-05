package com.zdzy.timephd.system.model;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zdzy.framework.bean.BaseBean;

public class Module extends BaseBean{
	
	public static Log log = LogFactory.getLog(Module.class);
	
	private String id;
	private String name;
	private Integer number;
	private String descb;
	private Date createDate;
	private Date updateDate;
	public static Log getLog() {
		return log;
	}
	public static void setLog(Log log) {
		Module.log = log;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getDescb() {
		return descb;
	}
	public void setDescb(String descb) {
		this.descb = descb;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}