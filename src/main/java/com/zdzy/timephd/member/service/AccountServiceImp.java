package com.zdzy.timephd.member.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.member.dao.AccountDao;
import com.zdzy.timephd.member.dao.LoginLogDao;
import com.zdzy.timephd.member.model.Account;
import com.zdzy.timephd.util.Function;

@Service("accountService")
public class AccountServiceImp implements AccountService {
	public static Log log = LogFactory.getLog(AccountServiceImp.class);
	@Autowired
	@Qualifier("accountDao")
	private AccountDao accountDao;
	

	
	@Override
	public String saveAccount(Account account) {
		String id ="";
		try {
			if (Function.isEmpty(account.getId())) {
				id =UUID.randomUUID().toString();
				account.setRegistTime(new Date());
				account.setId(id);
				//account.setAccountState(AccountStatusEnum.WAIT_ACTIVATE.getValue());//激活状态
				account.setPassword(Function.MD5(account.getPassword()));//密码加密
				account.setIdentyCode(UUID.randomUUID().toString());//生成认证码
				accountDao.insert(account);
			} else {
				id=account.getId();
				accountDao.update(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}
	@Override
	public boolean removeAccount(String id) {
		boolean flag = false;
		try {
			this.accountDao.delete(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public PageObject queryAccount(QueryParamater param) {
		PageObject po = null;
		try {
			po = this.accountDao.query(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public Account findAccount(String accountID) {
		Account account = null;
		try {
			account = this.accountDao.select(accountID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}





	@Override
	public Account loginByName(String loginName) {
		Account account = null;
		try {
			account = this.accountDao.loginByName(loginName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public boolean countByLoginName(String loginName) {
		boolean flag = false;
		try {
			int num = this.accountDao.countByLoginName(loginName);
			if(num<=0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean countByEmail(String email) {
		boolean flag = false;
		try {
			int num = this.accountDao.countByEmail(email);
			if(num<=0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
    

	
	@Override
	public Account findAccountByEmail(String email) {
		return this.accountDao.loginByEmail(email);
	}


	@Override
	public boolean update(Account account) {
		int ret = this.accountDao.update(account);
		return ret>0?true:false;
	}


	@Override
	public Account findAccountByShortId(String shortId) {
		Account account = null;
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("shortId",shortId);
			account = accountDao.queryByMap(map).get(0);
		}catch (Exception e){
			e.printStackTrace();
		}
		return account;
	}


}
