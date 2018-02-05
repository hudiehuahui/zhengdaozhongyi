package com.zdzy.timephd.member.model;

import java.util.Date;

import com.zdzy.framework.bean.BaseBean;

public class LoginLog extends BaseBean{

	private String id; //
	private String userId; //用户id
	private String logIp; //登录ip
	private Date loginTime; //登录时间
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	public void setLogIp(String logIp){
		this.logIp=logIp;
	}
	
	public void setLoginTime(Date loginTime){
		this.loginTime=loginTime;
	}
	 
	public String getId(){
		return id;
	}
	 
	public String getUserId(){
		return userId;
	}
	 
	public String getLogIp(){
		return logIp;
	}
	 
	public Date getLoginTime(){
		return loginTime;
	}
}