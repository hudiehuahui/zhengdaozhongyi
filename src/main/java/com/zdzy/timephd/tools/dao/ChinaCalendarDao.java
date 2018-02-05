package com.zdzy.timephd.tools.dao;

import java.util.Date;
import java.util.Map;

import com.zdzy.framework.dao.BaseDao;
import com.zdzy.timephd.tools.model.ChinaCalendar;

public interface ChinaCalendarDao extends BaseDao<ChinaCalendar,String>{
	/**
	 * 查询到期时间
	 * @return
	 */
	public Date queryRankWorkday(String urgentDays);

	/**
	 * 查询某一个指定的工作日的 前后指定的几个工作日是那一天
	 * @param map
	 * @return
     */
	public Date queryThePointedDay(Map map);

	/**
	 * 查询今天日期
	 * @return
	 * @author bxt-chen
	 */
	public ChinaCalendar queryChinaCalendarByDate(String date);
}
