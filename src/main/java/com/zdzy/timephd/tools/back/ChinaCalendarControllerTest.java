package com.zdzy.timephd.tools.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdzy.timephd.tools.service.ChinaCalendarService;

@Controller
@RequestMapping("/tools/chinaCalendar")
public class ChinaCalendarControllerTest {
	@Autowired
	private ChinaCalendarService chinaCalendarService;
	
	@RequestMapping(value = "/saveChinaCalendar.do", method = { RequestMethod.GET })
	@ResponseBody
	public String  saveChinaCalendar (){
		boolean flag = false;
		//chinaCalendarService.saveChinaCalendar();
		flag = chinaCalendarService.saveChinaCalendar();
		if (flag) {
			return "success";
		}
		return "failed";
	}

}
