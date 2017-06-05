package yong.project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import yong.bbs.model.BbsDAO;
import yong.project.model.ProjectDAO;
import yong.project.model.ProjectDTO;

@Controller
public class ProjectController {

	@Autowired
	private ProjectDAO projectDao;
	
	@RequestMapping("/projectMain.do")
	public ModelAndView mainForm(@RequestParam(value="cp", defaultValue="1") int cp){
		ModelAndView mav = new ModelAndView();
		
		int totalCnt = projectDao.getTotalCnt();
		totalCnt = totalCnt == 0 ? 1 : totalCnt; // 0의 유효성 검사
		int listSize = 5; // 보여줄 리스트 수
		int pageSize = 5; // 보여줄 페이지 수
		
		List<Object> arry_mater = projectDao.materList(cp, listSize);
		String pageStr = yong.page.PageModule2.makePage("projectMain.do", totalCnt, listSize, pageSize, cp);
		
		mav.addObject("arry_mater", arry_mater);
		System.out.println(pageStr);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping(value="/mateUpdate.do", method=RequestMethod.GET)
	public ModelAndView materUpdateForm(ProjectDTO input_dto){
		ModelAndView mav = new ModelAndView();
	
		Object mdto = projectDao.materInfo(input_dto);
	
		mav.addObject("mdto", mdto);
		mav.setViewName("materUpdateForm");
		
		return mav;
	}
	
	@RequestMapping(value="/mateUpdate.do", method=RequestMethod.POST)
	public ModelAndView materUpdate(ProjectDTO input_dto, 
			@RequestParam("upload") MultipartFile upload, 
			HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
	
		
		//String savepath = "C:/Users/111/git/myweb3/myweb3/src/main/webapp/upload";
	
		input_dto.setSajin_nm(upload.getOriginalFilename());
		int result = projectDao.materUpdate(input_dto);
		
		if(result > 0){
			copyInto(upload);
		}
		String msg = result > 0 ? "수정 완료" : "수정 실패";
		
		
		
		mav.addObject("msg", msg);
		mav.setViewName("materUpdate_ok");
		return mav;
	}
	
	/** 복사관련 사용자 정의 메서드 */
	private void copyInto(MultipartFile upload){
		
		FileOutputStream fos = null;
		
		try {
			// 1. 업로드된 파일의 바이트 배열을 가져온다.
			byte bytes[] = upload.getBytes();
			// 2. 업로드된 파일의 이름으로 새로운 파일 객체를 생성한다. 현재는 실제로 존재 X.
			File outFile = new File("C:/Users/111/git/myweb3/myweb3/src/main/webapp/upload/" + upload.getOriginalFilename());  
			// 3. 파일을 복사하기위해 FileOutputStream 을 생성.
			fos = new FileOutputStream(outFile);
			// 4. write를 이용해 해당 바이트를 복사.
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				if(fos!=null)fos.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value="/mateInsert.do", method=RequestMethod.GET)
	public ModelAndView materInsertForm(){
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("materInsertForm");
		return mav;
	}
	
	@RequestMapping(value="/mateInsert.do", method=RequestMethod.POST)
	public ModelAndView materInsert(ProjectDTO input_dto, 
			@RequestParam("upload") MultipartFile upload, 
			HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
	
		
		// 이미지 안올렸을 경우..
		if(upload.isEmpty()){
			// 남자인 경우
			if(input_dto.getSex().equals("1")){
				input_dto.setSajin_nm("default_man.jpg");
			// 여자인 경우
			} else {
				input_dto.setSajin_nm("default_woman.jpg");
			}
		}else{
			input_dto.setSajin_nm(upload.getOriginalFilename());
			
			
		}
		
		int result = projectDao.materInsert(input_dto);
		if(result > 0 && !upload.isEmpty() ){
			copyInto(upload);
		}
		String msg = result > 0 ? "입력 완료" : "입력 실패";
		
		mav.addObject("msg", msg);
		mav.setViewName("materInsert_ok");
		return mav;
	
	}
}
