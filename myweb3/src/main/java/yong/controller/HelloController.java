package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

/*
 * 스프링에서는 어노테이션 기법을 제공한다. (상속을 하지 않으며 작성 가능)
 */
@Controller
public class HelloController{
	
	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		String msg = "spring mvc framework 적용 결과 !";
		// 1 회성 데이터 이기 때문에 프로토타입으로 객체를 생성한다.
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", msg);
		mav.setViewName("dd/hello");
	
		return mav;
	}
}
