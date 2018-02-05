package com.zdzy.timephd.member.dao;

import java.util.List;
import java.util.Map;

import com.zdzy.framework.dao.BaseDao;
import com.zdzy.timephd.member.model.Account;

public interface AccountDao extends BaseDao<Account, String>
{

	/**
	 * 根据登录名查询用户
	 * @param loginName
	 * @return
	 */
	Account loginByName(String loginName);
	
	/**
	 * 统计注册会员的个数
	 * @return 返回会员个数
	 */
	int statisticsAccount();
	/**
	 * 查询当前用户名有多少个
	 * @param loginName
	 * @return
	 */
	public int countByLoginName(String loginName);
	/**
	 * 查询当前用户邮箱是否存在
	 * @param email
	 * @return
	 */
	public int countByEmail(String email);
	
	/**
	 * 根据邮箱登录
	 * @date 		2016-3-21下午2:49:39
	 * @mail 		humin@bjca.org.cn
	 * @author 		humin
	 * @param email
	 * @return
	 */
	Account loginByEmail(String email);

	List<Account> queryByMap(Map<String, Object> map1);
}