package yong.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import yong.memo.model.MemoDAO;
import yong.memo.model.MemoDTO;

@Controller
// 하위 모든 메소드가 전부 매핑 된다. value를 지울수있다. (단 , 두개가 전부일 경우)
/*@RequestMapping("/memoWrite.do")*/
public class MemoController {
	
	@Autowired
	private MemoDAO memoDao; // 오토라이더 : 자동 샛터를 호출해서 샛팅
	
	// /memoWrite.do 로 접속하고 GET방식으로 접속했을 경우.
	@RequestMapping(value="/memoWrite.do", method=RequestMethod.GET)
	//@RequestMapping(method=RequestMethod.GET)
	public ModelAndView memoForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memo/memoForm");
		return mav;
	}
	
	//@RequestMapping(value="/memoWrite.do", method=RequestMethod.POST)
	//@RequestMapping(method=RequestMethod.POST)  // @ModelAttribute("cmd") 별칭
	/*public ModelAndView memoSubmit(@ModelAttribute("cmd")MemoDTO command){ // 배개변수에 DTO를 작성시 setProperty="*" 과 같다.
																		   // 진입 메서드로 들어온 dto는 다음 페이지까지 넘어간다.
		int result = memoDao.memoWrite(command);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memo/memoSuccess");
		
		return mav;
	}*/
	
	@RequestMapping(value="/memoWrite2.do", method=RequestMethod.GET)
	public ModelAndView memoSubmit2(HttpServletRequest req){

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		//int result = memoDao.memoWrite(command);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memo/memoSuccess");
		
		return mav;
	}
	
	/*@RequestMapping(method=RequestMethod.POST)
	public ModelAndView memoSubmit(HttpServletRequest req){

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		//int result = memoDao.memoWrite(command);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memo/memoSuccess");
		
		return mav;
	}*/
}
