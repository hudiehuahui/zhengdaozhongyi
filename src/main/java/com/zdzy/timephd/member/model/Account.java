package com.zdzy.timephd.member.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zdzy.framework.bean.BaseBean;
import com.zdzy.timephd.statuscode.Constants;
import com.zdzy.timephd.system.model.Admin;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@JsonIgnoreProperties(value={"handler"})
public class Account extends BaseBean{
	
	private String id; //
	private String userName; //登录名称
	private String password; //登录密码
	private String phoneNumber;//电话号码
	private int sex;//性别
	private String nation;//民族
	private Date lastLogTime; //最后登录时间
	private Date registTime; //注册时间
	private String email; //邮箱
	private int accountType; //用户类型
	private int accountState; //账号状态账号 状态0未激活1已激活2停用
	private String nickname; //账户昵称
	private String headImg; //账户头像
	private String source; //账户来源
	private String identyCode; //激活码
	private Integer syncStatus;//状态
	private String  shortId;//用户短ID
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogTime() {
		return lastLogTime;
	}

	public void setLastLogTime(Date lastLogTime) {
		this.lastLogTime = lastLogTime;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getAccountState() {
		return accountState;
	}

	public void setAccountState(int accountState) {
		this.accountState = accountState;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIdentyCode() {
		return identyCode;
	}

	public void setIdentyCode(String identyCode) {
		this.identyCode = identyCode;
	}

	public String getShortId() {
		return shortId;
	}

	public void setShortId(String shortId) {
		this.shortId = shortId;
	}

	/**
	 * 获取session中账号信息
	 * @return
	 */
	public static Account sessionAccount() {
		try {
			HttpSession session=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			Account account=session.getAttribute(Constants.SESSION_MEMBER) != null ? (Account) session.getAttribute(Constants.SESSION_MEMBER):null;
			return account;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	/**
	 * 更新session中用户
	 * @param admin
	 * @return
	 */
	public static boolean updateSessionAccount(Account account) {
		boolean flag=false;
		try{
		HttpSession session=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.setAttribute(Constants.SESSION_MEMBER, account);
		flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	

	}
}