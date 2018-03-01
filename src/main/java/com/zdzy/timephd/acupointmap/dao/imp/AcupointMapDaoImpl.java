package com.zdzy.timephd.acupointmap.dao.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zdzy.framework.dao.IbatisDaoImp;
import com.zdzy.timephd.acupointmap.dao.AcupointMapDao;
import com.zdzy.timephd.acupointmap.model.AcupointMap;
import com.zdzy.timephd.member.model.Account;
@Repository("acupointMapDao")
public class AcupointMapDaoImpl extends IbatisDaoImp<AcupointMap, String> implements AcupointMapDao
{

	@Override
	public List<AcupointMap> queryByMap(Map<String, Object> map) {
		return this.getSqlSession().selectList(this.getSqlmapNamespace() + ".queryAcupointMap" , map);
	}

}
