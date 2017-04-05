package yong.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;

@Controller
public class BbsController {
	
	@Autowired
	private BbsDAO bbsDao;
	
	@RequestMapping(value="bbsList.do")
	public ModelAndView bbsList(@RequestParam(value="cp", defaultValue="1") int cp){
		
		
		
		
		int totalCnt = bbsDao.getTotalCnt();
		totalCnt = totalCnt == 0 ? 1 : totalCnt; // 0의 유효성 검사
		int listSize = 5; // 보여줄 리스트 수
		int pageSize = 5; // 보여줄 페이지 수
		
		List<BbsDTO> list = bbsDao.bbsList(cp, listSize);
		String pageStr = yong.page.PageModule.makePage("bbsList.do", totalCnt, listSize, pageSize, cp);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("bbs/bbsList");
		return mav;
	}
	
	
	
	
}
