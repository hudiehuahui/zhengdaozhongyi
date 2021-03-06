package com.zdzy.timephd.tools.dao.imp;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.tools.dao.ChinaCalendarDao;
import com.zdzy.timephd.tools.model.ChinaCalendar;
@Repository("chinaCalendarDao")
public class ChinaCalendarDaoImpl extends IbatisDaoImp<ChinaCalendar, String> implements ChinaCalendarDao{
	public Date queryRankWorkday(String urgentDays){
		return this.getSqlSession().selectOne(this.getSqlmapNamespace() +".queryRankWorkday");
	}

	/**
	 * 查询某一个指定的工作日的 前后指定的几个工作日是那一天
	 *
	 * @param map
	 * @return
	 */
	@Override
	public Date queryThePointedDay(Map map) {
		return this.getSqlSession().selectOne(this.getSqlmapNamespace() +".queryThePointedDay",map);
	}

	@Override
	public ChinaCalendar queryChinaCalendarByDate(String date) {
		return this.getSqlSession().selectOne(this.getSqlmapNamespace() +".queryChinaCalendarByDate",date);
	}
}
