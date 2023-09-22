package com.web.core0922.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ModelAndView
 * 디스패쳐 서블릿에 의해 처리될 뷰를 직접 지정할 수 있고, Model부분에 있는 데이터를 전달할 수 있도록 한다.
 */
@Controller
public class ResponseViewController {
	@RequestMapping("/response-view-v1")
	public ModelAndView responseViewV1() {
		ModelAndView mav = new ModelAndView("response/hello").addObject("data", "dataValue");
		mav.addObject("title", "response-view-v1");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/response-view-v2")
	public String responseViewV2(Model model) {
		model.addAttribute("data", "hello!!");
		return "response/hello";
	}
}
