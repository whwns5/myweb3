package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AniController {
	
	// @ModelAttribute -- AniController 안의 모든 요소에 대해 데이터를 공유한다.
	@ModelAttribute("keyword")
	public String[] getKeyword(){
		String keyword[] = {"세일러문", "천사소녀 네티", "해모수", "라젠타", "다간"};
		return keyword;
	}
	@ModelAttribute("cate")
	public String[] getCategory(){
		String cate[] = {"한국", "일본", "미국"};
		return cate;
	}
	
	@RequestMapping("/aniFindA.do")
	public ModelAndView aniFindA(){
		/*String keyword[] = {"세일러문", "천사소녀 네티", "해모수", "라젠타", "다간"};
		String cate[] = {"한국", "일본", "미국"};*/
		
		ModelAndView mav = new ModelAndView();
		
		/*mav.addObject("keyword", getKeyword());
		mav.addObject("cate", getCategory());*/
		mav.setViewName("ani/aniFindA");
		
		return mav;
	}
	
	@RequestMapping("/aniFindB.do")
	public String aniFindB(Model model){
		/*String keyword[] = {"세일러문", "천사소녀 네티", "해모수", "라젠타", "다간"};
		String cate[] = {"한국", "일본", "미국"};*/
		
		/*model.addAttribute("keyword", getKeyword());
		model.addAttribute("cate", getCategory());*/
		
		return "ani/aniFindB";	
	}
}
