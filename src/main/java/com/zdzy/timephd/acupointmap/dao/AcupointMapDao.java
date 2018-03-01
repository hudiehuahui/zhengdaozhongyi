package com.zdzy.timephd.acupointmap.dao;

import java.util.List;
import java.util.Map;

import com.zdzy.framework.dao.BaseDao;
import com.zdzy.timephd.acupointmap.model.AcupointMap;
import com.zdzy.timephd.member.model.Account;

public interface AcupointMapDao extends BaseDao<AcupointMap, String>
{

	List<AcupointMap> queryByMap(Map<String, Object> map1);
}