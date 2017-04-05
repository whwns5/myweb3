package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewTestController {
	
	/** 명시적 뷰 지정 방법 (ModelAndView) */
	@RequestMapping("/viewTest1.do")
	public ModelAndView viewTest1(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("view/viewTest");
		return mav;
	}
	/** 명시적 뷰 지정 방법 2 (String) */
	@RequestMapping("/viewTest2.do")
	public String viewTest2(){
		return "view/viewTest";
	}
	/** 묵시적 뷰 지정 방법 (void) */
	@RequestMapping("/view/viewTest.do") // 도메인의 URL 기준으로 가져온다 
	public void viewTest3(){			 // view/viewTest 만큼을 잘라서 자동으로 이동
		
	}
	/** 컨트롤러 에서 또 다른 명령어 를 호출하는 방법 */
	@RequestMapping("/viewTest4.do")
	public String viewTest4(){
		return "redirect:/hello.do"; 
	}
	
	
}
