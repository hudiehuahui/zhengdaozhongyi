package com.zdzy.timephd.member.service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.member.model.Account;

public interface AccountService {

	/**
	 * 添加账户或更新账户
	 * 
	 * @param Account
	 * @return id
	 */
	public String saveAccount(Account account);

	/**
	 * 根据删除账户
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeAccount(String id);

	/**
	 * 查询所有账户
	 * 
	 * @param param
	 * @return
	 */
	public PageObject queryAccount(QueryParamater param);
	
	/**
	 * 根据ID查询账户
	 * 
	 * @param AccountID
	 * @return
	 */
	public Account findAccount(String accountID);

	/**
	 * 根据登录名称查询用户
	 * 
	 * @param loginName
	 * @return
	 */
	public Account loginByName(String loginName);

	/**
	 * 查询当前用户有多少条
	 * 
	 * @param loginName
	 * @return
	 */
	public boolean countByLoginName(String loginName);

	/**
	 * 查询当前用户邮箱是否存在
	 * 
	 * @param loginName
	 * @return
	 */
	public boolean countByEmail(String email);

	/**
	 * 根据邮箱查询用户
	 * @date 		2016-3-21下午2:46:58
	 * @mail 		humin@bjca.org.cn
	 * @author 		humin
	 * @param email
	 * @return
	 */
	public Account findAccountByEmail(String email);
	
	
	/**
	 * 更新账户状态
	 * @param account
	 */
	public boolean update(Account account);
	/**
	 * 根据keyid查询account
	 * @param keyid
	 * @return
	 * @author 
	 * @date 2016.7.3
	 */

	public Account findAccountByShortId(String shortId);
}
