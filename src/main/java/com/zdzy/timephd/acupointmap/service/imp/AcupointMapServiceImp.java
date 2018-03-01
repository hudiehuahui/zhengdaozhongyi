package com.zdzy.timephd.acupointmap.service.imp;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.acupointmap.dao.AcupointMapDao;
import com.zdzy.timephd.acupointmap.service.AcupointMapService;

@Service("acupointMapService")
public class AcupointMapServiceImp implements AcupointMapService {
	public static Log log = LogFactory.getLog(AcupointMapServiceImp.class);
	@Resource
	private AcupointMapDao acupointMapDao;

	@Override
	public PageObject queryAcupointMap(QueryParamater param) {
		PageObject po = null;
		try {
			po = this.acupointMapDao.query(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}


}
