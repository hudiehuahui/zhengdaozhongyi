/**
 * Feb 12, 2018
 */
package com.zdzy.timephd.acupointmap.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdzy.framework.page.PageObject;
import com.zdzy.framework.page.QueryParamater;
import com.zdzy.timephd.acupointmap.service.AcupointMapService;

/** 穴位图控制层
 * @ClassName: AcupointMapController 
 * @Description: 
 * @author humin 
 * @date Feb 12, 2018 4:18:27 PM 
 *  
 */
@Controller
@RequestMapping("/back/acupointMap/")
public class AcupointMapController {
	@Resource
	private AcupointMapService acupointMapService;
	
	/**
	 * 
	 * @Description: 查看所有穴位图集合
	 * @author: humin
	 * @since: Feb 12, 2018 5:05:48 PM
	 * @param: 
	 * @return
	 */
	@RequestMapping("allAcupointImage.do")
	public String allAcupointImage(HttpServletResponse response, HttpServletRequest request,ModelMap modelMap){
		QueryParamater param = new QueryParamater();
		PageObject queryAcupointMapList = this.acupointMapService.queryAcupointMap(param);
		modelMap.put("queryAcupointMapList", queryAcupointMapList);
		return "back/acupointMap/allImage";
	}
	
	/**
	 * 
	 * @Description: 穴位图明细
	 * @author: humin
	 * @since: Feb 12, 2018 5:06:09 PM
	 * @param: 
	 * @return
	 */
	@RequestMapping("detailImage.do")
	public String detailImage(HttpServletResponse response, HttpServletRequest request,ModelMap modelMap,String path){
		modelMap.put("path", path);
		return "back/acupointMap/detailImage";
	}
	
	
	 
}
