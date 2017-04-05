package yong.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yong.member.model.MemberDAO;
import yong.member.model.MemberDAOImple;
import yong.member.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDao;
	
	/** 회원가입 폼 이동 */
	@RequestMapping(value="/memberJoin.do", method=RequestMethod.GET)
	public ModelAndView memberJoinForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberJoinForm");
		return mav;
	}
	
	/** 회원가입 처리 */
	@RequestMapping(value="/memberJoin.do", method=RequestMethod.POST)
	public ModelAndView memberJoin(MemberDTO command){
	
		ModelAndView mav = new ModelAndView();
		
		int result = memberDao.memberAdd(command);
		String msg = result > 0 ? "회원가입 완료" : "회원가입 실패";
		//String href = "index.do";
		String href = "index.do";
		
		mav.addObject("msg", msg);
		mav.addObject("href", href);

		mav.setViewName("member/memberMsg");
		
		return mav;
	}
	
	/** 아이디 체크 폼 이동*/
	@RequestMapping(value="/memberIdCheck.do", method=RequestMethod.GET)
	public ModelAndView memberIdCheckForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberIdCheckForm");
		return mav;
	}
	
	/** 아이디 체크 처리*/
	@RequestMapping(value="/memberIdCheck.do", method=RequestMethod.POST)
	public ModelAndView memberIdCheck(MemberDTO command){
		ModelAndView mav = new ModelAndView();
		
		String id = command.getId();
		boolean result = memberDao.idCheck(id);
		String msg = "";
		String href = "";
		if(result){
			msg = "\"" + id + "\" 는 이미 존재하는 아이디 입니다.";
			href = "memberIdCheck.do";
			mav.addObject("href", href);
			mav.setViewName("member/memberMsg");
		} else {
			msg = "\"" + id + "\" 는 사용할 수 있는 아이디 입니다.";
			href = "/member/memberAdd_IdCheck_ok.jsp";
			mav.addObject("id", id);
			mav.setViewName("member/memberIdCheck_ok");
			
		}
		
		mav.addObject("msg", msg);

		return mav;
	}
	
	/** 로그인 폼 이동 */
	@RequestMapping(value="memberLogin.do", method=RequestMethod.GET) // GET 방식 일 경우
	public ModelAndView memberLoginForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberLoginForm");
		return mav;
	}
	/** 로그인 처리 */
	@RequestMapping(value="memberLogin.do", method=RequestMethod.POST) // POST 방식 일 경우
	public ModelAndView memberLogin(MemberDTO mdto, @RequestParam(value="cbSaveId", defaultValue="off") String cbSaveId, HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		
		int result = memberDao.loginCheck(mdto.getId(), mdto.getPwd());
		String msg = "";
		String href = "";
		String view = "";
		if( result == ((MemberDAOImple) memberDao).LOGIN_OK ){ // 로그인 성공시 
			MemberDTO login_mdto = memberDao.loginInfo(mdto.getId());
			
			HttpSession session = req.getSession();
			session.setAttribute("login_mdto", login_mdto);
			
			if(cbSaveId.equals("on")){ // 아이디 기억 체크시 ..
				Cookie ck = new Cookie("ck_saveId", login_mdto.getId());
				ck.setMaxAge(60*60*24*30); // 한달간
				resp.addCookie(ck);
			} else if (cbSaveId.equals("off")){
				Cookie ck = new Cookie("ck_saveId", "");
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}
			
			msg = login_mdto.getName() + " 님 환영합니다.";
			view = "member/memberLogin_ok";
		} else if ( result == ((MemberDAOImple) memberDao).LOGIN_ID_ERROR ){ // 아이디 실패시
			msg = "해당 아이디가 잘못 되었습니다.";
			href = "memberLogin.do";
			view = "member/memberMsg";
			
		} else if ( result == ((MemberDAOImple) memberDao).LOGIN_PWD_ERROR ){ // 비밀번호 실패시
			msg = "비밀번호가 잘못 되었습니다.";
			href = "memberLogin.do";
			view = "member/memberMsg";
		}
		
		mav.addObject("msg", msg);
		mav.addObject("href", href);
		mav.setViewName(view);
		
		return mav;
	}
	
	/** 로그아웃 처리 */
	@RequestMapping("memberLogOut.do")
	public ModelAndView memberLogOut(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		mav.addObject("href","index.do");
		mav.setViewName("member/memberMsg");
		
		return mav; 
	}
}























