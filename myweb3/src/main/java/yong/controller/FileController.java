package yong.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import yong.filetest.FileDTO;

@Controller
public class FileController {
	
	/** 파일 업로드 폼 이동 */
	@RequestMapping(value="/fileUploadForm.do")
	public String fileUploadForm(){
		return "file/fileUploadForm";
	}
	
//	@RequestMapping(value="/fileUpload1.do")
//	public String fileUpload1(){
//		return "file/fileSuccess";
//	}
	
	/** @ ReqeustParam 전달 방식 */
	@RequestMapping(value="/fileUpload1.do")
	public String fileUpload1(
			@RequestParam("writer") String writer, 
			@RequestParam("upload") MultipartFile upload){ // MultipartFile -> 기존 File 클래스와 비슷. 스프링버전
		
		copyInto(writer, upload);
		
		return "file/fileSuccess";
	}
	/** MultipartHttpServletRequest 전달방식 */ 
	@RequestMapping(value="/fileUpload2.do") // MultipartHttpServletRequest -> Request를 상속받아 구현된 스프링의 Multipart형 Request
	public String fileUpload2(MultipartHttpServletRequest req){
		String writer = req.getParameter("writer");
		MultipartFile upload = req.getFile("upload");
		
		copyInto(writer, upload);
		
		return "file/fileSuccess";
	}
	/** DTO 객체로 전달하는 방식 */
	@RequestMapping(value="/fileUpload3.do")
	public String fileUpload3(@ModelAttribute(value="fd") FileDTO dto){
		
		copyInto(dto.getWriter(), dto.getUpload());
		
		return "file/fileSuccess";
	}
	
	/** 복사관련 사용자 정의 메서드 */
	private void copyInto(String writer, MultipartFile upload){
		
		FileOutputStream fos = null;
		
		try {
			// 1. 업로드된 파일의 바이트 배열을 가져온다.
			byte bytes[] = upload.getBytes();
			// 2. 업로드된 파일의 이름으로 새로운 파일 객체를 생성한다. 현재는 실제로 존재 X.
			File outFile = new File("E:/upload/" + upload.getOriginalFilename());  
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
	
	/** 파일리스트 폼 메서드 */
	@RequestMapping(value="/fileDownList.do")
	public ModelAndView fileList(){
		ModelAndView mav = new ModelAndView();
		
		File f = new File("E:/upload");
		File files[] = f.listFiles();
	
		mav.addObject("files", files);
		mav.setViewName("file/fileList");
		
		return mav;
	}
	@RequestMapping(value="fileDown.do")
	public ModelAndView fileDown(@RequestParam("filename") String filename){
		System.out.println("filename == " + filename);
		File f = new File("E:/upload/" + filename);
		
		ModelAndView mav = new ModelAndView("yongDown", "downloadFile", f);
		
		return mav;
	}
	
	/*@RequestMapping(value="fileDown.do")
	public ModelAndView fileDown(HttpServletRequest req){
		
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String filename = req.getParameter("filename");
		
		System.out.println("filename == " + filename);
		
		File f = new File("E:/upload/" + filename);
		
		ModelAndView mav = new ModelAndView("yongDown", "downloadFile", f);
		
		return mav;
	}*/
	
	
}















