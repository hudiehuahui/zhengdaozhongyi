package com.zdzy.timephd.member.dao.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.member.dao.AccountDao;
import com.zdzy.timephd.member.model.Account;
@Repository("accountDao")
public class AccountDaoImpl extends IbatisDaoImp<Account, String> implements AccountDao
{

	@Override
	public Account loginByName(String loginName) {

		return (Account)this.getSqlSession().selectOne(this.getSqlmapNamespace() + ".loginByName", loginName);
	}
	
	@Override
	public int statisticsAccount() {
		return this.getSqlSession().selectOne(this.getSqlmapNamespace() + ".statisticsAccount");
	}

	

	@Override
	public int countByLoginName(String loginName) {
		return (Integer)this.getSqlSession().selectOne(this.getSqlmapNamespace() + ".countByLoginName",loginName);
	}

	@Override
	public int countByEmail(String email) {
		return (Integer)this.getSqlSession().selectOne(this.getSqlmapNamespace() + ".countByEmail",email);
	}


	@Override
	public Account loginByEmail(String email) {

		return (Account)this.getSqlSession().selectOne(this.getSqlmapNamespace() + ".loginByEmail" , email);
	}

	@Override
	public List<Account> queryByMap(Map<String, Object> map) {
		return this.getSqlSession().selectList(this.getSqlmapNamespace() + ".queryByMap" , map);
	}

}
