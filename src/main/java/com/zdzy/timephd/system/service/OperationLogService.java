package com.zdzy.timephd.system.service;

import org.apache.ibatis.executor.parameter.ParameterHandler;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.system.model.OperationLog;



public interface OperationLogService {
	
	/**
	 * 操作日志处理
	 * @date 		2016-5-4上午10:31:46
	 * @mail 		humin@bjca.org.cn
	 * @author 		humin
	 * @param operationLogSql
	 * @param Parameter
	 */
	public void batchProcess(String operationLogSql,String parameterJson);
	
	/**
	 * 保存及更新
	 * @date 		2016-5-4上午10:32:23
	 * @mail 		humin@bjca.org.cn
	 * @author 		humin
	 * @param operationLog
	 * @return
	 */
	public boolean saveOperationLog(OperationLog operationLog);

	/**
	 * 根据条件查询
	 * @date 		2016-5-4上午10:32:11
	 * @mail 		humin@bjca.org.cn
	 * @author 		humin
	 * @param param
	 * @return
	 */
    public PageObject queryOperationLog(QueryParamater param);
    
}
