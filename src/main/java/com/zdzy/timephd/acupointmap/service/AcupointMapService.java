package com.zdzy.timephd.acupointmap.service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.member.model.Account;

public interface AcupointMapService {

	/**
	 * 查询所有账户
	 * 
	 * @param param
	 * @return
	 */
	public PageObject queryAcupointMap(QueryParamater param);
	
}
