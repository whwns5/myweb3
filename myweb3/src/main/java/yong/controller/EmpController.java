package yong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;
import yong.emp.model.EmpTestDTO;

@Controller
public class EmpController {
	
	@Autowired
	private EmpDAO empDao;
	
	@RequestMapping(value="/emp.do")
	public String empMain(){
		return "emp/emp";
	}
	
	@RequestMapping(value="/empAdd.do")
	public ModelAndView empAddAction(EmpDTO dto /*, EmpTestDTO etdto*/){
		int result = empDao.empAdd(dto);
		String msg = result > 0 ? "사원등록성공!" : "사원등록실패!";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("emp/empMsg");
		
		return mav;
	}
	
	@RequestMapping(value="/empDel.do")
	public String empDelAction(@RequestParam("name") String name, Model model){
	
		int result = empDao.empDel(name);
		String msg = result > 0 ? "사원삭제성공!" : "사원삭제실패!";
		
		model.addAttribute("msg", msg);
		
		return "emp/empMsg";
	}
	
	/*@RequestMapping(value="/empDel.do")
	public ModelAndView empDelAction(@RequestParam("name") String name, ModelAndView mav){
	
		int result = empDao.empDel(name);
		String msg = result > 0 ? "사원삭제성공!" : "사원삭제실패!";
		
		mav.addObject("msg", msg);
		mav.setViewName("emp/empMsg");
		
		return mav;
	}*/
	
	@RequestMapping("empList.do")
	public ModelAndView empList(ModelAndView mav){
		mav.addObject("empList", empDao.empList());
		mav.setViewName("emp/empList");
		return mav;
	}
	
	@RequestMapping("empSearch.do")
	public ModelAndView empList(@RequestParam("idx") int idx, ModelAndView mav){
		EmpDTO dto = empDao.empSearch(idx);
		ArrayList<EmpDTO> empList = new ArrayList<EmpDTO>();
		empList.add(dto);
		
		mav.addObject("empList", empList);
		mav.setViewName("emp/empList");
		return mav;
	}
	
	/*@RequestMapping("empSelect.do")
	public String empList(@ModelAttribute(value="empList") EmpDTO dto){
		dto = empDao.empList(dto.getIdx());
		return "emp/empList";
	}*/
	
	/*@RequestMapping(value="empUpdate.do", method=RequestMethod.GET)
	public String empUpdateForm(@RequestParam(value="idx") int idx, Model model){
		model.addAttribute("dto", empDao.empSearch(idx));
		return "emp/empUpdateForm";
	}*/
	
	@RequestMapping(value="empUpdate.do", method=RequestMethod.GET)
	public String empUpdateForm(@ModelAttribute("edto") EmpDTO dto, Model model, Model model2, Model model3){
		//dto = empDao.empSearch(dto.getIdx());
		//model.addAttribute("dto", dto);
		dto = empDao.empSearch(dto.getIdx());
		//model.addAttribute("dto1", empDao.empSearch(dto.getIdx()));
		model2.addAttribute("dto2", dto);
		model3.addAttribute("dto3", empDao.empSearch(dto.getIdx()));
		return "emp/empUpdateForm";
	}
	
	@RequestMapping(value="empUpdate.do", method=RequestMethod.POST)
	public String empUpdate(EmpDTO dto, Model model){
		model.addAttribute("msg", empDao.empUpdate(dto) > 0 ? "회원수정완료!" : "회원수정실패!");
		return "emp/empMsg";
	}
	
	
	
	
}
