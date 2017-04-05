package yong.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 해당 클래스를 controller 로 인식하게 해준다.
public class ParamController {
	
	//////////////////////////////////////// 파라미터 ////////////////////////////////////
    // @RequestMapping 명령어 맵핑.	  // @RequestParam 리퀘스트 파라미터 값을 얻어온다.
	@RequestMapping("/paramTest.do")  // value = 값을 넣어준다 , required = 값의 필수 조건(false=없을수도 있다) , defaultValue = 없을때 기본값 
	public ModelAndView paramTest(@RequestParam(value="idx", /*required=false,*/ defaultValue="1") int idx, // 해당 값을 자동 파싱하여 int로 만들어준다.
			@RequestParam(value="str", required=false) String str){
		
		System.out.println("idx = " + idx);
		System.out.println("str = " + str);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("param/paramSuccess");
		return mav;
	}
	@RequestMapping("/paramTest2.do")
	public ModelAndView paramTest2(HttpServletRequest req){
		
		System.out.println("idx = " + req.getParameter("idx"));
		System.out.println("str = " + req.getParameter("str"));
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("param/paramSuccess");
		return mav;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////// 쿠키 ///////////////////////////////////////
	@RequestMapping("/cookieView.do") // @CookieValue(쿠키아이디 값) -- 
	public ModelAndView cookieView(@CookieValue(value="saveid" /*,required=false*/ ,defaultValue="noId") String saveid){
		
		System.out.println("saveid = " + saveid);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("param/paramSuccess");
		return mav;
	}
	@RequestMapping("/cookieMake.do")
	public ModelAndView cookieMake(HttpServletResponse resp){
		
		// 1. 쿠키 객체 생성
		Cookie ck = new Cookie("saveid", "hong");
		// 2. 쿠키 나이 설정
		ck.setMaxAge(60*60); // 1시간
		// 3. response에 쿠키 저장
		resp.addCookie(ck);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("param/paramSuccess");
		return mav;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/sessionView.do")
	public ModelAndView sessionView(HttpServletRequest req){
		
		// 1. 세션 객체 생성
		HttpSession session = req.getSession();
		// 2. 세션 가져오기
		String name = (String) session.getAttribute("name");
		
		System.out.println(name);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("param/paramSuccess");
		return mav;
	}
	@RequestMapping("/sessionMake.do")
	public ModelAndView sessionMake(HttpSession session){
		
		session.setAttribute("name", "홍길동");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("param/paramSuccess");
		return mav;
	}
	
}



















